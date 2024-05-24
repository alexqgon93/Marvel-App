package com.example.marvel_app.feature.charactersDetail

import com.example.marvel_app.domain.models.characters.Character

data class CharactersDetailUiState(
    val character: Character? = null,
    val screenState: ScreenState = ScreenState.LOADING
)

enum class ScreenState { LOADING, ERROR, SUCCESS }