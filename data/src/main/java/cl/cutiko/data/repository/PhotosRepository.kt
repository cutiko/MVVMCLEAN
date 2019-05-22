package cl.cutiko.data.repository

import cl.cutiko.models.Photo

class PhotosRepository(private val photosDataSource: PhotosDataSource) : PhotosDataSource {

    override suspend fun getPhotos(): List<Photo>? = photosDataSource.getPhotos()


}