package com.example.marvel_app.feature.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.domain.models.comics.Comic
import com.example.marvel_app.domain.usecases.UseCaseComics
import com.example.marvel_app.feature.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(private val useCaseComics: UseCaseComics) : ViewModel() {
//    private val _state = MutableStateFlow(ComicsUiState(screenState = ScreenState.LOADING))
//    val state = _state.asStateFlow()
//    private var comicsArray: List<Comic> = emptyList()

    val state = Comic.Format.entries.associateWith { MutableStateFlow(ComicsUiState()) }

//    init {
//        viewModelScope.launch {
//            useCaseComics.invoke().fold(
//                ifLeft = {
//                    _state.value = ComicsUiState(screenState = ScreenState.ERROR)
//                },
//                ifRight = { comics ->
//                    comicsArray = comics.data.results
//                    _state.value = ComicsUiState(
//                        screenState = ScreenState.SUCCESS,
//                        comics = filterByFormat(comicsArray, Comic.Format.COMIC)
//                    )
//                }
//            )
//        }
//    }

    private fun filterByFormat(comics: List<Comic>, format: Comic.Format): List<Comic> =
        comics.filter { it.format == format }


//    fun formatRequested(format: Comic.Format) {
//        _state.value = ComicsUiState(
//            screenState = ScreenState.SUCCESS,
//            comics = filterByFormat(comicsArray, format)
//        )
//    }

    fun formatRequested(format: Comic.Format) {
        val uiState = state.getValue(format)
        val comics = uiState.value.comics
        if (comics.isEmpty()) {
            viewModelScope.launch {
                uiState.value = ComicsUiState(screenState = ScreenState.LOADING)
                useCaseComics.invoke(format = format.name).fold(
                    ifLeft = {
                        uiState.value = ComicsUiState(screenState = ScreenState.ERROR)
                    },
                    ifRight = { comics ->
                        uiState.value = ComicsUiState(
                            screenState = ScreenState.SUCCESS,
                            comics = filterByFormat(comics.data.results, format)
                        )
                    }
                )
            }
        }
    }
}