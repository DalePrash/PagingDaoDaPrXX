package com.example.roomservicetocachedapr

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.practiseaadapr.data.NewsList
import com.example.practiseaadapr.data.NewsPojo
// @Database(entities = [RickAndMortyDummy::class], version = 1, exportSchema = true)

//@Database(entities = [NewsList::class], version = 1, exportSchema = true)
abstract class NewsListDataBase {
    /*
    : RoomDatabase() {
    abstract fun newsListAbs(): NewsListOrigDao?
    fun destroyDataBase() {
        INSTANCE = null
    }
// @TypeConverters(Converters::class)
    companion object {
        @Volatile
        private var INSTANCE: NewsListDataBase? = null
        @JvmStatic
        fun getDatabase(context: Context): NewsListDataBase? {
            if (INSTANCE == null) {
                synchronized(NewsListDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            NewsListDataBase::class.java, "news_database"
                        )
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        private val sRoomDatabaseCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }
    }

     */
}