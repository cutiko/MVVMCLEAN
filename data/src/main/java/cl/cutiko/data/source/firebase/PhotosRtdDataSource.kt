package cl.cutiko.data.source.firebase

import android.content.Context
import androidx.annotation.VisibleForTesting
import cl.cutiko.data.BuildConfig
import cl.cutiko.data.repository.PhotosDataSource
import cl.cutiko.models.Photo
import cl.cutiko.models.PhotosWrapper
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class PhotosRtdDataSource : PhotosDataSource {

    override suspend fun getPhotos(): List<Photo>? {
        return suspendCoroutine { continuation ->
            mvvm.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) continuation.resume(snapshot.getValue(PhotosWrapper::class.java)?.photos) else emptyList<Photo>()
                }
                override fun onCancelled(error: DatabaseError) = continuation.resume(emptyList())
            })
        }
    }

    /**
     * Firebase app has to be initialized manually because this is not the app module
     * Testing need to use this, in different modules, is better to solve it here than to carry a dependency around
     */
    @VisibleForTesting
    fun initializeFirebase(context: Context) {
        val NO_APPS = 0
        when (FirebaseApp.getApps(context).size) {
            NO_APPS -> {
                val builder = FirebaseOptions.Builder()
                    .setApiKey(BuildConfig.apiKey)
                    .setApplicationId(BuildConfig.applicationId)
                    .setDatabaseUrl(BuildConfig.databaseUrl)
                    .setProjectId(BuildConfig.projectId)
                    .build()
                FirebaseApp.initializeApp(context, builder)
            }
        }
    }

}
