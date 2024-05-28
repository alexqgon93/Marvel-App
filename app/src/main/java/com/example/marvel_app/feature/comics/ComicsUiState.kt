package com.example.marvel_app.feature.comics

import com.example.marvel_app.domain.models.comics.Comic
import com.example.marvel_app.feature.ScreenState

data class ComicsUiState(
    val screenState: ScreenState = ScreenState.LOADING,
    val comics: List<Comic> = emptyList()
)