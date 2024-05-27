package com.example.marvel_app.feature.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.domain.usecases.UseCaseComics
import com.example.marvel_app.feature.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(private val useCaseComics: UseCaseComics) : ViewModel() {
    private val _state = MutableStateFlow(ComicsUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            useCaseComics.invoke().fold(
                ifLeft = {
                    _state.value = ComicsUiState(screenState = ScreenState.ERROR)
                },
                ifRight = { comics ->
                    _state.value = ComicsUiState(
                        screenState = ScreenState.SUCCESS,
                        comics = comics.data.results
                    )
                }
            )
        }
    }
}