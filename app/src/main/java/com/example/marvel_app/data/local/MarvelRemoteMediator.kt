package com.example.marvel_app.data.local

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.marvel_app.data.mappers.characters.toCharacterEntity
import com.example.marvel_app.database.MarvelDatabase
import com.example.marvel_app.database.models.CharacterEntity
import com.example.marvel_app.network.source.DataSource
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class MarvelRemoteMediator(
    private val dataSource: DataSource,
    private val marvelDatabase: MarvelDatabase,
) : RemoteMediator<Int, CharacterEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) 1
                    else (lastItem.id / state.config.pageSize) + 1
                }
            }
            val characters = dataSource.getCharacters(
                offset = loadKey,
                limit = state.config.pageSize
            )
            marvelDatabase.withTransaction {
                val characterEntities = characters.map { networkCharacters ->
                    networkCharacters.data.results.map { it.toCharacterEntity() }
                }.getOrNull() ?: emptyList()
                marvelDatabase.marvelDao().upsertCharacters(characterEntities)
            }
            MediatorResult.Success(
                endOfPaginationReached = characters.isEmpty()
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}