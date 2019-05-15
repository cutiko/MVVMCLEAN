package cl.cutiko.mvvmclean.domain.usecases

import androidx.lifecycle.MutableLiveData
import cl.cutiko.mvvmclean.data.models.Photo
import cl.cutiko.mvvmclean.data.repository.PhotosRepository
import cl.cutiko.mvvmclean.data.source.rest.getInterceptor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class GetPhotosUseCase(private val photosRepository: PhotosRepository) : BaseUseCase<List<Photo>?, MutableLiveData<LiveState<List<Photo>?>>>() {

    override suspend fun doWork(): List<Photo>? = photosRepository.getPhotos()

}