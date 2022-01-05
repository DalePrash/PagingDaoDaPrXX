package com.example.practiseaadapr.data

import androidx.room.Entity
import androidx.room.PrimaryKey
//import com.example.rickymortydapr.network.Info
import com.google.gson.annotations.SerializedName

@Entity(tableName = "xxx_table")
public data class NewsPojo(@PrimaryKey(autoGenerate = true)
                        @SerializedName("id") var id: Int, @SerializedName("author") var author:  String)


//public data class NewsPojo(@PrimaryKey(autoGenerate = true)
//                        @SerializedName("id") var id: Int, @SerializedName("name") var name: String, @SerializedName("author") var author:  String)
//

//@Entity(tableName = "newslist_table")
public data class NewsList( var id: Int,@SerializedName("articles")var movieList :List<NewsPojo>)





/*  public data class Pojob(@PrimaryKey(autoGenerate = true)
                          @SerializedName("id") var id: Int, var isAdult: Boolean,    @SerializedName("original_language")
var original_language: String,     @SerializedName("original_title")
var original_title: String)

 */

