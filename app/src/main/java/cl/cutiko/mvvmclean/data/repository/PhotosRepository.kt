package cl.cutiko.mvvmclean.data.repository

import androidx.lifecycle.MutableLiveData
import cl.cutiko.mvvmclean.data.models.Photo
import cl.cutiko.mvvmclean.domain.usecases.LiveState

interface PhotosRepository {

    suspend fun getPhotos() : List<Photo>?

}