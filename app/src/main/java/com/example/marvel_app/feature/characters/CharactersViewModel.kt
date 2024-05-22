package com.example.marvel_app.feature.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.domain.usecases.UseCaseCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val useCaseCharacters: UseCaseCharacters
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersUiState())
    val state = _state.asStateFlow()

    fun getCharacters() = viewModelScope.launch {
        useCaseCharacters.invoke().fold(
            ifLeft = {
                _state.update { it.copy(screenState = ScreenState.ERROR) }
            },
            ifRight = {characters ->
                _state.update {
                    it.copy(
                        screenState = ScreenState.SUCCESS,
                        characters = characters.data.results
                    )
                }
            }
        )
    }
}