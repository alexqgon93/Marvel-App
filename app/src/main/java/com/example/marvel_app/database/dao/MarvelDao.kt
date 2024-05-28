package com.example.marvel_app.database.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.example.marvel_app.database.models.CharacterEntity

@Dao
fun interface MarvelDao {

//    @Upsert
//    suspend fun upsertComics(comics: List<ComicEntity>)

    @Upsert
    suspend fun upsertCharacters(characters: List<CharacterEntity>)

//    @Upsert
//    suspend fun upsertCreators(creators: List<CreatorEntity>)
//
//    @Upsert
//    suspend fun upsertEvents(events: List<EventEntity>)
}