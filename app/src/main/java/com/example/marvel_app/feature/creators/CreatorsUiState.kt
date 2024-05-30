package com.example.marvel_app.feature.creators

import com.example.marvel_app.domain.models.creators.Creator
import com.example.marvel_app.feature.ScreenState

data class CreatorsUiState(
    val creators: List<Creator>? = null,
    val screenState: ScreenState = ScreenState.LOADING
)