package cl.cutiko.mvvmclean.data.source.rest

import cl.cutiko.mvvmclean.data.models.PhotosWrapper
import retrofit2.Call
import retrofit2.http.GET

interface Requests {

    @GET("/mvvm")
    fun getPhotos() : Call<PhotosWrapper>
}