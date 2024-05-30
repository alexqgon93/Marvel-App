package com.example.marvel_app.feature.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.domain.usecases.UseCaseEvents
import com.example.marvel_app.feature.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val useCaseEvents: UseCaseEvents
) : ViewModel() {

    private val _state = MutableStateFlow(EventsUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            useCaseEvents.invoke().fold(
                ifLeft = {
                    _state.value = EventsUiState(screenState = ScreenState.ERROR)
                },
                ifRight = { events ->
                    _state.value = EventsUiState(
                        events = events.data.events,
                        screenState = ScreenState.SUCCESS
                    )
                }
            )
        }
    }
}


