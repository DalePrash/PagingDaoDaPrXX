package com.example.roomservicetocachedapr

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.practiseaadapr.data.NewsPojo

@Dao
interface NewsOrigDao {
    @get:Query("SELECT * FROM xxx_table")
    val alphabetizedWords: NewsPojo?

  //  @Query("SELECT * FROM news_table")
    //fun getNewsList(): List<NewsPojo>

    @Query("SELECT * FROM xxx_table")
    fun getNews(): LiveData<NewsPojo>


    //    val alphabetizedWords: RickAndMortyList?
    // @Insert(onConflict = OnConflictStrategy.IGNORE) // REPLACE
    //  @Insert
    //  void insert(MovieList nTitle);
    // it will replace previous data when entering


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(nTitle: NewsPojo?)
   // fun insert(nTitle: RickAndMortyList)  these gave KAPT error
    //
//     fun insert(nTitle: RickAndMortyDummy?)


    @Delete
    fun delete(nTitle: NewsPojo?)

    @Query("DELETE FROM xxx_table")
    fun deleteAll() // @RawQuery("SELECT * FROM news_table")
}