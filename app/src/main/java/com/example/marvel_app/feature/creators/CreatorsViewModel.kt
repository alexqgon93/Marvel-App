package com.example.marvel_app.feature.creators

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.domain.usecases.UseCaseCreators
import com.example.marvel_app.feature.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatorsViewModel @Inject constructor(
    private val useCaseCreators: UseCaseCreators
) : ViewModel() {

    private val _state = MutableStateFlow(CreatorsUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            useCaseCreators.invoke().fold(
                ifLeft = {
                    _state.value = CreatorsUiState(screenState = ScreenState.ERROR)
                },
                ifRight = {
                    _state.value = CreatorsUiState(
                        screenState = ScreenState.SUCCESS,
                        creators = it.data.creators
                    )
                }
            )
        }
    }
}