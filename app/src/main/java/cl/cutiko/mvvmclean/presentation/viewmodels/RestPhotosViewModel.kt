package cl.cutiko.mvvmclean.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.cutiko.mvvmclean.data.models.Photo
import cl.cutiko.mvvmclean.data.repository.PhotosDataSource
import cl.cutiko.mvvmclean.domain.usecases.GetPhotosUseCase
import cl.cutiko.mvvmclean.domain.usecases.LiveState

class RestPhotosViewModel : ViewModel() {

    private val _livePhotos = MutableLiveData<LiveState<List<Photo>?>>()
    val livePhotos = _livePhotos

    fun getPhotos(dataSource: PhotosDataSource) {
        GetPhotosUseCase(dataSource).backgroundWork(_livePhotos)
    }



}