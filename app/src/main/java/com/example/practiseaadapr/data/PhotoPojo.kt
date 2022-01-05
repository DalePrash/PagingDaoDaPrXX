package com.example.practiseaadapr.data

import androidx.room.Entity
import androidx.room.PrimaryKey
//import com.example.rickymortydapr.network.Info
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photo_table")
public data class PhotoPojo(@PrimaryKey(autoGenerate = true)
                        @SerializedName("id") var id: Int, @SerializedName("original_language") var type: String, @SerializedName("original_language") var user:  String)
  /*  public data class Pojob(@PrimaryKey(autoGenerate = true)
                            @SerializedName("id") var id: Int, var isAdult: Boolean,    @SerializedName("original_language")
var original_language: String,     @SerializedName("original_title")
 var original_title: String)

   */

