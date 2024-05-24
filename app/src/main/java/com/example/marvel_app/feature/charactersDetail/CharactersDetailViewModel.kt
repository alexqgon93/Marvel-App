package com.example.marvel_app.feature.charactersDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.domain.usecases.UseCaseCharacter
import com.example.marvel_app.feature.charactersDetail.navigation.CHARACTER_DETAIL_ARGUMENT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCaseCharacter: UseCaseCharacter
) : ViewModel() {
    private val characterId: String = checkNotNull(savedStateHandle[CHARACTER_DETAIL_ARGUMENT])

    private val _state = MutableStateFlow(CharactersDetailUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            useCaseCharacter.invoke(characterId).fold(
                ifLeft = {
                    _state.value = CharactersDetailUiState(screenState = ScreenState.ERROR)
                },
                ifRight = { character ->
                    _state.value = CharactersDetailUiState(
                        screenState = ScreenState.SUCCESS,
                        character = character.data.results.first()
                    )
                }
            )
        }
    }
}