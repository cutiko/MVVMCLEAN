package cl.cutiko.data.source.rest

import cl.cutiko.models.PhotosWrapper
import retrofit2.Call
import retrofit2.http.GET

interface Requests {

    @GET("/mvvm")
    fun getPhotos() : Call<PhotosWrapper>
}