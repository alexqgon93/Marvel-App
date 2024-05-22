package com.example.marvel_app.feature.characters

import com.example.marvel_app.domain.models.characters.Character

data class CharactersUiState(
    val screenState: ScreenState = ScreenState.LOADING,
    val characters: List<Character>? = null
)

enum class ScreenState { LOADING, SUCCESS, ERROR }