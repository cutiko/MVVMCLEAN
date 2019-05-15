package cl.cutiko.mvvmclean.domain.usecases

import cl.cutiko.mvvmclean.data.models.Photo
import cl.cutiko.mvvmclean.data.models.PhotosWrapper
import cl.cutiko.mvvmclean.data.repository.PhotosRepository
import cl.cutiko.mvvmclean.data.source.firebase.mvvm
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RtdPhotosUseCase : PhotosRepository {

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
