package com.example.practiseaadapr.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "mov_table")
    public data class Pojob(@PrimaryKey(autoGenerate = true)
                            @SerializedName("id") var id: Int, var isAdult: Boolean,    @SerializedName("original_language")
var original_language: String,     @SerializedName("original_title")
 var original_title: String)

