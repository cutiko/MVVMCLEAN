package cl.cutiko.mvvmclean.domain.viewmodels

import cl.cutiko.mvvmclean.data.repository.PhotosDataSource
import cl.cutiko.mvvmclean.data.source.firebase.PhotosRtdDataSource

class PhotosRtdViewModel : PhotosViewModel() {

    override val dataSource: PhotosDataSource = PhotosRtdDataSource()
}