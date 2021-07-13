package com.example.simpleapp.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson


class Converters {

    @TypeConverter
    fun toString(value: List<Int>?): String? = Gson().toJson(value) ?: null

    @TypeConverter
    fun jsonToList(value: String?): List<Int> =
        Gson().fromJson(value, Array<Int>::class.java).toList()
}