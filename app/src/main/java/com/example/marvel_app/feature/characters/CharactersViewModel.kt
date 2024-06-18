package com.example.marvel_app.feature.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.marvel_app.data.mappers.characters.toCharacter
import com.example.marvel_app.database.models.CharacterEntity
import com.example.marvel_app.domain.usecases.UseCaseCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val useCaseCharacters: UseCaseCharacters,
    pager: Pager<Int, CharacterEntity>,
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersUiState())
    val state = _state.asStateFlow()

    private val characterFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toCharacter() }
        }.cachedIn(viewModelScope)

//    fun getCharacters() = viewModelScope.launch {
//        useCaseCharacters.invoke().fold(
//            ifLeft = {
//                _state.update { it.copy(screenState = ScreenState.ERROR) }
//            },
//            ifRight = {characters ->
//                _state.update {
//                    it.copy(
//                        screenState = ScreenState.SUCCESS,
//                        characters = characters.data.results
//                    )
//                }
//            }
//        )
//    }
}