package com.example.rickymortydapr

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.practiseaadapr.data.NewsPojo
import com.example.rickymortydapr.network.RetroInstance
import com.example.rickymortydapr.network.RetroService
import com.example.roomservicetocachedapr.APICl
import kotlinx.coroutines.flow.Flow

public class MainActivityViewModel(): ViewModel() {
    lateinit var contextC: Context

     var retroService: RetroService

    init {
      //  retroService = RetroInstance.getRetroInstance().create(RetroService::class.java)
        retroService = APICl.client!!.create(RetroService::class.java)
      //  contextC = context
        Log.v("AABB", "VIEWMODEL INIT")


    }
    //  val apiService = APICl.client?.create(RetroService::class.java)
    //
    //
    //        val responsexx=  apiService?.topRatedNews

    fun getListData(): Flow<PagingData<NewsPojo>> {
        return Pager (config = PagingConfig(pageSize = 5, maxSize = 25),
        pagingSourceFactory = {CharacterPagingSource(retroService)}).flow.cachedIn(viewModelScope)
    }
}