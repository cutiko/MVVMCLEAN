package cl.cutiko.photosdomain.viewmodels

import androidx.lifecycle.ViewModel
import cl.cutiko.data.repository.PhotosDataSource
import cl.cutiko.domain.usecases.LiveResult
import cl.cutiko.models.Photo
import cl.cutiko.photosdomain.usecases.GetPhotosUseCase

abstract class PhotosViewModel : ViewModel() {

    protected abstract val dataSource : PhotosDataSource
    private val _livePhotos = LiveResult<List<Photo>?>()
    val livePhotos = _livePhotos

    fun getPhotos() {
        GetPhotosUseCase(dataSource).backgroundWork(_livePhotos)
    }



}