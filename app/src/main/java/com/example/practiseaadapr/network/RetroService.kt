package com.example.rickymortydapr.network

import com.example.practiseaadapr.data.NewsList
import com.example.practiseaadapr.data.NewsPojo
import com.example.practiseaadapr.data.PhotoPojo
import com.example.practiseaadapr.data.Pojob
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

public interface RetroService {

  //  @Headers("Accept: application/json")
   // @GET("?page=2&key=20045329-0613298a4e814661c692a9f03")
    @get:GET("?page=2&key=20045329-0613298a4e814661c692a9f03")
    val getDataFromAPI: Call<PhotoPojo>

  @get:GET("550?api_key=b199eab06bc931ed71cd20c95e4b2bb3")
  val topRatedMovie: Call<Pojob>
    //suspend fun getDataFromAPI(): Call<PhotoPojo>
    @get:GET(" everything?q=sports&apiKey=aa67d8d98c8e4ad1b4f16dbd5f3be348")
    val topRatedNews: Call<NewsPojo>

  @get:GET(" everything?q=sports&apiKey=aa67d8d98c8e4ad1b4f16dbd5f3be348")
  val topRatedNewsList: Call<NewsList>

  @get:GET(" everything?q=sports&apiKey=aa67d8d98c8e4ad1b4f16dbd5f3be348")
  val straightNewsList: NewsList

  @GET(" everything?q=sports&apiKey=aa67d8d98c8e4ad1b4f16dbd5f3be348")
  suspend fun straightNewsListB(): NewsList



}