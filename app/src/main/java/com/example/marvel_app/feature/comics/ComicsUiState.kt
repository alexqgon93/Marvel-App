package com.example.marvel_app.feature.comics

import com.example.marvel_app.domain.models.comics.Comic

data class ComicsUiState(
    val screenState: ScreenState = ScreenState.LOADING,
    val comics: List<Comic>? = null
)

enum class ScreenState { LOADING, SUCCESS, ERROR }