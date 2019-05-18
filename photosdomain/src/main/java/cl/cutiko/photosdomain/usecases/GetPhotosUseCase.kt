package cl.cutiko.photosdomain.usecases


import cl.cutiko.photomodel.Photo
import cl.cutiko.photosdata.repository.PhotosDataSource
import cl.cutiko.photosdata.repository.PhotosRepository

class GetPhotosUseCase(private val photosDataSource: PhotosDataSource) : BaseUseCase<List<Photo>?>() {

    override suspend fun doWork(): List<Photo>? = PhotosRepository(photosDataSource).getPhotos()

}