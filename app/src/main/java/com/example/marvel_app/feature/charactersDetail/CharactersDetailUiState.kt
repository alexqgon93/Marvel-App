package com.example.marvel_app.feature.charactersDetail

import com.example.marvel_app.domain.models.characters.Character
import com.example.marvel_app.feature.ScreenState

data class CharactersDetailUiState(
    val character: Character? = null,
    val screenState: ScreenState = ScreenState.LOADING
)
