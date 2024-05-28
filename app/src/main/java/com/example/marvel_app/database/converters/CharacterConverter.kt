package com.example.marvel_app.database.converters

import androidx.room.TypeConverter
import com.example.marvel_app.domain.models.common.Image
import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.Url
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class CharacterConverter {

    val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @TypeConverter
    fun itemsToString(items: Items): String = moshi.adapter(Items::class.java).toJson(items)

    @TypeConverter
    fun stringToItems(itemsString: String): Items =
        moshi.adapter(Items::class.java).fromJson(itemsString)!!


    @TypeConverter
    fun imageToString(image: Image): String = moshi.adapter(Image::class.java).toJson(image)

    @TypeConverter
    fun stringToImage(imageString: String): Image =
        moshi.adapter(Image::class.java).fromJson(imageString)!!

    @TypeConverter
    fun listUrlToString(urls: List<Url>): String = moshi.adapter(List::class.java).toJson(urls)

    @TypeConverter
    fun stringToListUrl(urlsString: String): List<Url> =
        moshi.adapter<List<Url>>(Types.newParameterizedType(List::class.java, Url::class.java))
            .fromJson(urlsString) ?: emptyList()

}