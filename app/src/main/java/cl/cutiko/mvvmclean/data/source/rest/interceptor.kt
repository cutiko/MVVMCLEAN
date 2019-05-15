package cl.cutiko.mvvmclean.data.source.rest

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://us-central1-mvvm-cutiko.cloudfunctions.net"

fun getInterceptor(): Requests {
    val httpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)

    val client = httpClient.build()

    val interceptor = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    return interceptor.create(Requests::class.java)
}