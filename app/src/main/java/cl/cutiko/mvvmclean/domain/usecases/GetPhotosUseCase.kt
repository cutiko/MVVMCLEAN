package cl.cutiko.mvvmclean.domain.usecases

import cl.cutiko.mvvmclean.data.models.Photo
import cl.cutiko.mvvmclean.data.repository.PhotosDataSource
import cl.cutiko.mvvmclean.data.repository.PhotosRepository

class GetPhotosUseCase(private val photosDataSource: PhotosDataSource) : BaseUseCase<List<Photo>?>() {

    override suspend fun doWork(): List<Photo>? = PhotosRepository(photosDataSource).getPhotos()

}