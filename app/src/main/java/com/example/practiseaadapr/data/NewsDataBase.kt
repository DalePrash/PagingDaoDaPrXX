package com.example.roomservicetocachedapr

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.practiseaadapr.data.NewsPojo
// @Database(entities = [RickAndMortyDummy::class], version = 1, exportSchema = true)
@Database(entities = [NewsPojo::class], version = 1, exportSchema = true)
abstract class NewsDataBase : RoomDatabase() {
    abstract fun newsAbs(): NewsOrigDao?
    fun destroyDataBase() {
        INSTANCE = null
    }
// @TypeConverters(Converters::class)
    companion object {
        @Volatile
        private var INSTANCE: NewsDataBase? = null
        @JvmStatic
        fun getDatabase(context: Context): NewsDataBase? {
            if (INSTANCE == null) {
                synchronized(NewsDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            NewsDataBase::class.java, "news_database"
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
}