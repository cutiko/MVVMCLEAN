package cl.cutiko.photosdomain.viewmodels

import androidx.lifecycle.ViewModel
import cl.cutiko.photomodel.Photo
import cl.cutiko.photosdata.repository.PhotosDataSource
import cl.cutiko.photosdomain.usecases.GetPhotosUseCase
import cl.cutiko.photosdomain.usecases.LiveResult

abstract class PhotosViewModel : ViewModel() {

    protected abstract val dataSource : PhotosDataSource
    private val _livePhotos = LiveResult<List<Photo>?>()
    val livePhotos = _livePhotos

    fun getPhotos() {
        GetPhotosUseCase(dataSource).backgroundWork(_livePhotos)
    }



}