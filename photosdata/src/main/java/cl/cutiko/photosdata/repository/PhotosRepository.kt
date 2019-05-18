package cl.cutiko.photosdata.repository

import cl.cutiko.photomodel.Photo

class PhotosRepository(private val photosDataSource: PhotosDataSource) : PhotosDataSource {

    override suspend fun getPhotos(): List<Photo>? = photosDataSource.getPhotos()


}