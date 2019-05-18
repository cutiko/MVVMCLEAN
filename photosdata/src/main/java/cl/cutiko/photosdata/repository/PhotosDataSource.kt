package cl.cutiko.photosdata.repository

import cl.cutiko.photomodel.Photo

interface PhotosDataSource {

    suspend fun getPhotos() : List<Photo>?

}