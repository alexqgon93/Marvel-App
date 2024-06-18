package com.example.marvel_app.database.di

import com.example.marvel_app.database.MarvelDatabase
import com.example.marvel_app.database.dao.MarvelDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun providesMarvelDao(appDatabase: MarvelDatabase): MarvelDao = appDatabase.marvelDao()
}