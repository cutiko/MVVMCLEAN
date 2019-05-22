package cl.cutiko.photosdomain.usecases


import cl.cutiko.data.repository.PhotosDataSource
import cl.cutiko.data.repository.PhotosRepository
import cl.cutiko.domain.usecases.BaseUseCase
import cl.cutiko.models.Photo

class GetPhotosUseCase(private val photosDataSource: PhotosDataSource) : BaseUseCase<List<Photo>?>() {

    override suspend fun doWork(): List<Photo>? = PhotosRepository(photosDataSource).getPhotos()

}