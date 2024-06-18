package com.example.marvel_app.database.di

import android.content.Context
import androidx.room.Room
import com.example.marvel_app.database.MarvelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DATABASE_NAME = "marvel_database"

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): MarvelDatabase =
        Room.databaseBuilder(
            context = context,
            klass = MarvelDatabase::class.java,
            name = DATABASE_NAME
        ).build()
}