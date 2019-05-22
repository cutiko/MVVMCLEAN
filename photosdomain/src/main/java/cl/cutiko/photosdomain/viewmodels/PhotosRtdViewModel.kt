package cl.cutiko.photosdomain.viewmodels

import cl.cutiko.data.repository.PhotosDataSource
import cl.cutiko.data.source.firebase.PhotosRtdDataSource

class PhotosRtdViewModel : PhotosViewModel() {

    override val dataSource: PhotosDataSource = PhotosRtdDataSource()
}