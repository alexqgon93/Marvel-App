package com.example.marvel_app.feature.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.data.mappers.comics.toStringFormat
import com.example.marvel_app.domain.models.comics.Comic
import com.example.marvel_app.domain.usecases.UseCaseComics
import com.example.marvel_app.feature.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(private val useCaseComics: UseCaseComics) : ViewModel() {
    val state = Comic.Format.entries.associateWith { MutableStateFlow(ComicsUiState()) }

    fun formatRequested(format: Comic.Format) {
        val uiState = state.getValue(format)
        val comics = uiState.value.comics
        if (comics.isEmpty()) {
            viewModelScope.launch {
                uiState.value = ComicsUiState(screenState = ScreenState.LOADING)
                useCaseComics.invoke(format = format.toStringFormat(), offset = 0, limit = 10).fold(
                    ifLeft = {
                        uiState.update { it.copy(screenState = ScreenState.ERROR) }
                    },
                    ifRight = { comics ->
                        uiState.update {
                            it.copy(
                                screenState = ScreenState.SUCCESS,
                                comics = comics.data.results
                            )
                        }
                    }
                )
            }
        }
    }
}