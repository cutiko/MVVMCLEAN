package cl.cutiko.photosdomain.viewmodels

import cl.cutiko.photosdata.repository.PhotosDataSource
import cl.cutiko.photosdata.source.rest.PhotosRestDataSource

open class PhotosRestViewModel : PhotosViewModel() {

    override val dataSource: PhotosDataSource = PhotosRestDataSource()

}