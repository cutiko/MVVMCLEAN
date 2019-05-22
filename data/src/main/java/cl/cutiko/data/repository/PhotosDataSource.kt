package cl.cutiko.data.repository

import cl.cutiko.models.Photo

interface PhotosDataSource {

    suspend fun getPhotos() : List<Photo>?

}