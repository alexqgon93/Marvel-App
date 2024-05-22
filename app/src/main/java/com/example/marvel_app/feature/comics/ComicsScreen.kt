package com.example.marvel_app.feature.comics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvel_app.domain.models.comics.Comic
import com.example.marvel_app.feature.comics.ScreenState.ERROR
import com.example.marvel_app.feature.comics.ScreenState.SUCCESS
import com.example.marvel_app.feature.comics.ScreenState.LOADING
import com.example.marvel_app.feature.common.ErrorView
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun ComicsScreenRoute(
    viewModel: ComicsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ComicsScreen(state = state, onClickComic = {})
    LaunchedEffect(Unit) {
        viewModel.getComics()
    }
}

@Composable
fun ComicsScreen(
    state: ComicsUiState,
    onClickComic: (Comic) -> Unit
) {
    when (state.screenState) {
        LOADING -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        SUCCESS -> TODO()
        ERROR -> ErrorView()
    }
}


@DevicePreviews
@Composable
private fun ComicsScreenPreview() = MarvelAppTheme {
    ComicsScreen(
        state = ComicsUiState(screenState = SUCCESS),
        onClickComic = {}
    )
}