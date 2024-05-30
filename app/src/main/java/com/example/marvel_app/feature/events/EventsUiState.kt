package com.example.marvel_app.feature.events

import com.example.marvel_app.domain.models.events.Event
import com.example.marvel_app.feature.ScreenState


data class EventsUiState(
    val screenState: ScreenState = ScreenState.LOADING,
    val events: List<Event>? = null,
)