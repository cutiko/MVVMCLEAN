package cl.cutiko.mvvmclean.data.repository

import cl.cutiko.mvvmclean.data.models.Photo

interface PhotosDataSource {

    suspend fun getPhotos() : List<Photo>?

}