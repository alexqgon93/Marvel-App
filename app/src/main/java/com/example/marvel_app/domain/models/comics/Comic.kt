package com.example.marvel_app.domain.models.comics

import com.example.marvel_app.domain.models.common.Image
import com.example.marvel_app.domain.models.common.Item
import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.Stories
import com.example.marvel_app.domain.models.common.Url

data class Comic(
    val characters: Characters,
    val collectedIssues: List<Item>,
    val collections: List<Any>,
    val creators: Creators,
    val dates: List<Date>,
    val description: String?,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: Items,
    val format: Format,
    val id: Int,
    val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
    val series: Item,
    val stories: Stories,
    val textObjects: List<TextObject>,
    val thumbnail: Image,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Item>
) {
    enum class Format {
        COMIC,
        MAGAZINE,
        TRADE_PAPERBACK,
        HARDCOVER,
        DIGEST,
        GRAPHIC_NOVEL,
        DIGITAL_COMIC,
        INFINITE_COMIC
    }
}