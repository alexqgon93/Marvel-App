package com.example.marvel_app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvel_app.database.converters.CharacterConverter
import com.example.marvel_app.database.dao.MarvelDao
import com.example.marvel_app.database.models.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
@TypeConverters(CharacterConverter::class)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelDao(): MarvelDao
}