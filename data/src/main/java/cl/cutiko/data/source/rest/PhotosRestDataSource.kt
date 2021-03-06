package cl.cutiko.data.source.rest

import cl.cutiko.data.repository.PhotosDataSource
import cl.cutiko.models.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class PhotosRestDataSource : PhotosDataSource {

    companion object {
        private const val SUCCESS = 200
    }

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