package cl.cutiko.mvvmclean.data.repository

import cl.cutiko.mvvmclean.data.models.Photo

class PhotosRepository(private val photosDataSource: PhotosDataSource) : PhotosDataSource {

    override suspend fun getPhotos(): List<Photo>? = photosDataSource.getPhotos()


}