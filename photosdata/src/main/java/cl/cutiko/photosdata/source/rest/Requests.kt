package cl.cutiko.photosdata.source.rest

import cl.cutiko.photomodel.PhotosWrapper
import retrofit2.Call
import retrofit2.http.GET

interface Requests {

    @GET("/mvvm")
    fun getPhotos() : Call<PhotosWrapper>
}