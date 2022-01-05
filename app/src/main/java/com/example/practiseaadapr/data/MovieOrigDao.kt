package com.example.roomservicetocachedapr

import androidx.room.*
import com.example.practiseaadapr.data.PhotoPojo

@Dao
interface MovieOrigDao {
    @get:Query("SELECT * FROM photo_table")
    val alphabetizedWords: PhotoPojo?
    //    val alphabetizedWords: RickAndMortyList?
    // @Insert(onConflict = OnConflictStrategy.IGNORE) // REPLACE
    //  @Insert
    //  void insert(MovieList nTitle);
    // it will replace previous data when entering
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(nTitle: PhotoPojo?)
   // fun insert(nTitle: RickAndMortyList)  these gave KAPT error
    //
//     fun insert(nTitle: RickAndMortyDummy?)
    @Delete
    fun delete(nTitle: PhotoPojo?)

    @Query("DELETE FROM photo_table")
    fun deleteAll() // @RawQuery("SELECT * FROM news_table")
}