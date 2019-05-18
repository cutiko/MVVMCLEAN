package cl.cutiko.photosdomain.viewmodels

import cl.cutiko.photosdata.repository.PhotosDataSource
import cl.cutiko.photosdata.source.firebase.PhotosRtdDataSource

class PhotosRtdViewModel : PhotosViewModel() {

    override val dataSource: PhotosDataSource = PhotosRtdDataSource()
}