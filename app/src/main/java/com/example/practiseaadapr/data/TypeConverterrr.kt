package com.example.practiseaadapr.data

import com.google.gson.Gson




class TypeConverterrr {

    fun IntoList(nn: NewsPojo):List<NewsPojo>{
        var list = mutableListOf<NewsPojo>()
        list.add(0, nn)
        return list
    }

    fun IntoEntity(list: List<NewsPojo>):NewsPojo{

        val gson = Gson()
        var entity: NewsPojo =list[0]
        return entity
    }


}