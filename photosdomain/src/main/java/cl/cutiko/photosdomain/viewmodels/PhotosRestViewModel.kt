package cl.cutiko.photosdomain.viewmodels

import cl.cutiko.data.repository.PhotosDataSource
import cl.cutiko.data.source.rest.PhotosRestDataSource

open class PhotosRestViewModel : PhotosViewModel() {

    override val dataSource: PhotosDataSource = PhotosRestDataSource()

}