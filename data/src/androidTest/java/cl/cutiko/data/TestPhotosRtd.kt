package cl.cutiko.data

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import cl.cutiko.data.source.firebase.PhotosRtdDataSource
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotosRtd {

    companion object {
        private const val NO_APPS = 0
    }

    private val photoRtd = PhotosRtdDataSource()

    @Test
    fun testGetPhotos() {
        //Firebase app has to be initialized manually, because this is not the app module
        val context = InstrumentationRegistry.getInstrumentation().context
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
        val photos = runBlocking { photoRtd.getPhotos() }
        assertNotEquals(0, photos?.size)
    }

}