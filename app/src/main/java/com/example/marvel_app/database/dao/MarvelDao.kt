package com.example.marvel_app.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.marvel_app.database.models.CharacterEntity

@Dao
interface MarvelDao {

//    @Upsert
//    suspend fun upsertComics(comics: List<ComicEntity>)

    @Upsert
    suspend fun upsertCharacters(characters: List<CharacterEntity>)

    @Query("SELECT * FROM characterentity")
    fun pagingSource(): PagingSource<Int, CharacterEntity>

//    @Upsert
//    suspend fun upsertCreators(creators: List<CreatorEntity>)
//
//    @Upsert
//    suspend fun upsertEvents(events: List<EventEntity>)
}