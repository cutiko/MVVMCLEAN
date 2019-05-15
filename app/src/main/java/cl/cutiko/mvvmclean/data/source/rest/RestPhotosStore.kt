package cl.cutiko.mvvmclean.data.source.rest

import cl.cutiko.mvvmclean.data.models.Photo
import cl.cutiko.mvvmclean.data.repository.PhotosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

private const val SUCCESS = 200

class RestPhotosStore : PhotosRepository {

    override suspend fun getPhotos(): List<Photo>? = withContext(Dispatchers.IO) {
        val requests = getInterceptor()
        val call = requests.getPhotos()
        try {
            val response = call.execute()
            if (response.isSuccessful && response.code() == SUCCESS && response.body()?.result == SUCCESS) {
                return@withContext response.body()?.photos
            }
            return@withContext emptyList<Photo>()
        } catch (e : IOException) {
            return@withContext emptyList<Photo>()
        }
    }
}