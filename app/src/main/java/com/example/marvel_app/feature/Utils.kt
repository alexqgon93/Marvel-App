package com.example.marvel_app.feature

import androidx.annotation.StringRes
import com.example.marvel_app.R
import com.example.marvel_app.domain.models.comics.Comic
import com.example.marvel_app.navigation.NavigationBarDestinations

@StringRes
fun Comic.Format.toStringRes(): Int = when (this) {
    Comic.Format.COMIC -> R.string.comic
    Comic.Format.MAGAZINE -> R.string.magazine
    Comic.Format.TRADE_PAPERBACK -> R.string.trade_paperback
    Comic.Format.HARDCOVER -> R.string.hardcover
    Comic.Format.DIGEST -> R.string.digest
    Comic.Format.GRAPHIC_NOVEL -> R.string.graphic_novel
    Comic.Format.DIGITAL_COMIC -> R.string.digital_comic
    Comic.Format.INFINITE_COMIC -> R.string.infinite_comic
}


@StringRes
fun NavigationBarDestinations.toStringResource(): Int = when (this) {
    NavigationBarDestinations.CHARACTERS_SCREEN -> R.string.characters
    NavigationBarDestinations.COMICS_SCREEN -> R.string.comics
    NavigationBarDestinations.EVENTS -> R.string.events
    NavigationBarDestinations.CREATORS -> R.string.creators
}


enum class ScreenState { LOADING, SUCCESS, ERROR }