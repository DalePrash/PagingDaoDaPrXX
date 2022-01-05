package com.example.rickymortydapr.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


public class RetroInstance {

    companion object {
        val baseURL = "https://pixabay.com/api/?"

       // https://newsapi.org/v2/everything?q=sports&apiKey=aa67d8d98c8e4ad1b4f16dbd5f3be348

        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        }
    }
}