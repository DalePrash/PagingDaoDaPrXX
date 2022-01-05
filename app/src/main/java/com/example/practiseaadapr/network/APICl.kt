package com.example.roomservicetocachedapr

import com.example.rickymortydapr.network.RetroService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object APICl {
    //const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    //const val BASE_URL = "https://pixabay.com/api/?"
    const val BASE_URL = "https://newsapi.org/v2/"

    private var retrofit: Retrofit? = null

    // GsonConverterFactory or JacksonConverterFactory
    val client: Retrofit?
        get() {
            if (retrofit == null) {


                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)

                val httpClient = OkHttpClient.Builder()
                httpClient.addInterceptor(logging)

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // GsonConverterFactory or JacksonConverterFactory
                  //  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   // .client(httpClient.build())
                    .build()
            }
            return retrofit
        }

    // GsonConverterFactory or JacksonConverterFactory
    // https://api.themoviedb.org/3/movie/550?api_key=b199eab06bc931ed71cd20c95e4b2bb3
    val `interface`: RetroService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // GsonConverterFactory or JacksonConverterFactory
                    .build()
            }
            return retrofit!!.create(RetroService::class.java)
        }
}