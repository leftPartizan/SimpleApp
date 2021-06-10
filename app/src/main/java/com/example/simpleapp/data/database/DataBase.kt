package com.example.simpleapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simpleapp.data.database.movies.MoviesDao
import com.example.simpleapp.data.database.movies.MoviesEntity

@Database(entities = [MoviesEntity::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun getMoviesDao(): MoviesDao

    companion object {
        @Volatile
        private var instance: DataBase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: createDataBase(context).also { instance = it }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java,
                "Database.db",
            ).build()
    }
}