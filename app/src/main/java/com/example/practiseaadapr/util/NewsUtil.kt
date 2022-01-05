package com.example.practiseaadapr.util

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.practiseaadapr.data.NewsList
import com.example.practiseaadapr.data.NewsPojo
import com.example.roomservicetocachedapr.NewsDataBase

public class NewsUtil: AppCompatActivity{
    constructor(){

    }
  public open suspend fun insertNewsInDao( pojo: NewsList){
      val moviedb = NewsDataBase.getDatabase(  this@NewsUtil)

      // val moviedb = NewsDataBase.getDatabase(  contextC)
      val moviedao = moviedb?.newsAbs()
      moviedao?.insert(pojo.movieList[1])
      Log.v("AABB", "PAGING ADDED in util")

  }
}