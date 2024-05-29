package com.example.marvel_app.data.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.marvel_app.data.local.MarvelRemoteMediator
import com.example.marvel_app.database.MarvelDatabase
import com.example.marvel_app.database.models.CharacterEntity
import com.example.marvel_app.network.source.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MediatorModule {

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun providePager(
        marvelDatabase: MarvelDatabase,
        dataSource: DataSource,
    ): Pager<Int, CharacterEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MarvelRemoteMediator(
                dataSource = dataSource, marvelDatabase = marvelDatabase
            ),
            pagingSourceFactory = {
                marvelDatabase.marvelDao().pagingSource()
            }
        )
    }

}