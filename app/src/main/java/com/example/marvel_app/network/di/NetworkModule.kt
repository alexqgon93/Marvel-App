package com.example.marvel_app.network.di

import com.example.marvel_app.BuildConfig
import com.example.marvel_app.network.api.ApiService
import com.example.marvel_app.network.utils.generateHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.Date
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    private const val BASE_URL = "https://gateway.marvel.com:443"
    private val ts = Date().time
    private val hash = generateHash(ts, BuildConfig.private_key, BuildConfig.public_key)

    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val original: Request = chain.request()
            val httpUrl: HttpUrl = original.url
            val url = httpUrl.newBuilder()
                .addQueryParameter("apikey", BuildConfig.public_key)
                .addQueryParameter("ts", ts.toString())
                .addQueryParameter("hash", hash)
                .build()
            return@addInterceptor chain.proceed(request = original.newBuilder().url(url).build())
        }.callTimeout(10, TimeUnit.SECONDS).connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
        return okHttpClient.addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    fun providesMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    @Provides
    fun providesRetrofit(
        baseUrl: String,
        converterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient,
    ): Retrofit = Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl)
        .addConverterFactory(converterFactory).build()

    @Provides
    fun providesMarvelInterface(
        converterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient,
    ): ApiService {
        val retrofit = providesRetrofit(
            baseUrl = BASE_URL,
            converterFactory = converterFactory,
            okHttpClient = okHttpClient,
        )
        return retrofit.create(ApiService::class.java)
    }
}