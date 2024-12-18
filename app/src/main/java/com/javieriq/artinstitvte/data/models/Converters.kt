package com.javieriq.artinstitvte.data.models

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        return list?.let { json.encodeToString(it) }
    }

    @TypeConverter
    fun toStringList(data: String?): List<String>? {
        return data?.let { json.decodeFromString(it) }
    }

    @TypeConverter
    fun fromIntList(list: List<Int>?): String? {
        return list?.let { json.encodeToString(it) }
    }

    @TypeConverter
    fun toIntList(data: String?): List<Int>? {
        return data?.let { json.decodeFromString(it) }
    }
}