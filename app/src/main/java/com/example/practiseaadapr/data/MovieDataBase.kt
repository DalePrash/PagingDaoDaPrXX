package com.example.roomservicetocachedapr

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.practiseaadapr.data.PhotoPojo
// @Database(entities = [RickAndMortyDummy::class], version = 1, exportSchema = true)
@Database(entities = [PhotoPojo::class], version = 1, exportSchema = true)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieAbs(): MovieOrigDao?
    fun destroyDataBase() {
        INSTANCE = null
    }
// @TypeConverters(Converters::class)
    companion object {
        @Volatile
        private var INSTANCE: MovieDataBase? = null
        @JvmStatic
        fun getDatabase(context: Context): MovieDataBase? {
            if (INSTANCE == null) {
                synchronized(MovieDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MovieDataBase::class.java, "photo_database"
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