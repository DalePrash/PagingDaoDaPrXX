package com.example.rickymortydapr

import android.content.Context
import android.util.Log
import androidx.lifecycle.Observer
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.practiseaadapr.activity.PagingActivity
import com.example.practiseaadapr.data.NewsPojo
import com.example.practiseaadapr.paging.Coreframework
import com.example.practiseaadapr.util.NewsUtil
import com.example.rickymortydapr.network.RetroService
import com.example.roomservicetocachedapr.NewsDataBase

class CharacterPagingSource(val apiService: RetroService): PagingSource<Int, NewsPojo>() {
   lateinit var contextC: Context
    init {
        //contextC = context
        Log.v("AABB", "Context PAGING")

    }

    // internal constructor() {}
   /* constructor() :super("aa"){
        Log.i("a","a")
    }
    constructor(K: Int): this() {
        Log.i("a","a")
    }
    constructor(K: Int, K2: Int) {
        Log.i("a","a")

    }

    */
    override fun getRefreshKey(state: PagingState<Int, NewsPojo>): Int? {

        return state.anchorPosition

    }
    /*companion object {
        private var instance: CharacterPagingSource? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }

     */

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsPojo> {
        return try {
            val nextPage: Int = params.key ?: FIRST_PAGE_INDEX
         //   val response = apiService.getDataFromAPI(nextPage)
           // val  response = apiService.straightNewsList
          val response =  apiService.straightNewsListB()
            Log.v("AABB", response?.toString())

           var k =  NewsUtil()
      //     k.insertNewsInDao(response)

            Log.v("AABB", "Paging  Source added")
        //    getAppContext
            var moviedb = NewsDataBase.getDatabase(  PagingActivity.getAppContext())
            var moviedao = moviedb?.newsAbs()
           moviedao?.insert(response.movieList[1])

            Log.v("AABB", "PAGING ADDED in Second case")

         //   val md = NewsDataBase.getDatabase(PagingActivity.getAppContext())
       //     val mdao = moviedb!!.newsAbs()
       //     val kkkk = moviedao?.alphabetizedWords

         //   val kkkk = moviedao?.alphabetizedWords

            Log.v("AABB", "retrieve")


            /* val moviedb = NewsDataBase.getDatabase(  context = Context)

             // val moviedb = NewsDataBase.getDatabase(  contextC)
             val moviedao = moviedb?.newsAbs()
             moviedao?.insert(response.movieList[1])
             Log.v("AABB", "PAGING ADDED")


             */





         /*   var nextPageNumber: Int? = null
            if(response?.info?.next != null) {
                val uri = Uri.parse(response?.info?.next!!)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }
            var prevPageNumber: Int? = null
         /*   if(response?.info?.prev != null) {
                val uri = Uri.parse(response?.info?.prev!!)
                val prevPageQuery = uri.getQueryParameter("page")

                prevPageNumber = prevPageQuery?.toInt()
            }

          */

          */
            LoadResult.Page(
                data = response.movieList,
                prevKey = null,
                nextKey = 2
            )
            /*   ?????
            LoadResult.Page(data = response.results,
                    prevKey = prevPageNumber,
                    nextKey = nextPageNumber)

             */
        }
        catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
/*
    var context: Context? = null
    var pagingSource: CharacterPagingSource? = null
    fun getInstance(mC: Context?): CharacterPagingSource? {
        if (context == null) {
            context = mC
        }
        if (pagingSource == null) {
            pagingSource = CharacterPagingSource()
        }
        return pagingSource
    }

 */

}