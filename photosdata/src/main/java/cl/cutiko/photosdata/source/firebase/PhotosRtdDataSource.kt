package cl.cutiko.photosdata.source.firebase

import cl.cutiko.photomodel.Photo
import cl.cutiko.photomodel.PhotosWrapper
import cl.cutiko.photosdata.repository.PhotosDataSource
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

}
