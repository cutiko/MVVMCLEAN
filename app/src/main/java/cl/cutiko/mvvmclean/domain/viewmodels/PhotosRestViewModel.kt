package cl.cutiko.mvvmclean.domain.viewmodels

import cl.cutiko.mvvmclean.data.repository.PhotosDataSource
import cl.cutiko.mvvmclean.data.source.rest.PhotosRestDataSource

open class PhotosRestViewModel : PhotosViewModel() {

    override val dataSource: PhotosDataSource = PhotosRestDataSource()

}