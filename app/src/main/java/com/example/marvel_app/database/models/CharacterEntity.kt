package com.example.marvel_app.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvel_app.domain.models.common.Image
import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.Url

@Entity(tableName = "characterentity")
data class CharacterEntity(
    val comics: Items,
    val description: String,
    val events: Items,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Items,
    val stories: Items,
    val thumbnail: Image,
    val urls: List<Url>
)
