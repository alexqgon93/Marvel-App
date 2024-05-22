package com.example.marvel_app.network.di

import com.example.marvel_app.network.source.DataSource
import com.example.marvel_app.network.source.DataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
fun interface ApiServiceBindsModule {
    @Binds
    fun bindsApiService(dataSource: DataSourceImp): DataSource
}