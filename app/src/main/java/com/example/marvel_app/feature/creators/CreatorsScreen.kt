package com.example.marvel_app.feature.creators

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvel_app.components.atoms.marvelItem.MarvelItemAtom
import com.example.marvel_app.components.atoms.marvelItem.MarvelItemModel
import com.example.marvel_app.components.molecules.gridMolecule.GridItems
import com.example.marvel_app.domain.models.common.asString
import com.example.marvel_app.domain.models.creators.Creator
import com.example.marvel_app.feature.ScreenState
import com.example.marvel_app.feature.common.ErrorView
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun CreatorsScreenRoute(
    viewModel: CreatorsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    CreatorsScreen(state = state, onClickCreator = {})
}

@Composable
fun CreatorsScreen(
    state: CreatorsUiState,
    onClickCreator: (Creator) -> Unit
) {
    when (state.screenState) {
        ScreenState.LOADING -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        ScreenState.SUCCESS -> GridItems(state.creators ?: emptyList()) { creator ->
            MarvelItemAtom(
                model = MarvelItemModel(
                    thumbnail = creator.thumbnail.asString(),
                    title = creator.firstName
                ),
                modifier = Modifier.clickable { onClickCreator(creator) }
            )
        }

        ScreenState.ERROR -> ErrorView()
    }
}

@DevicePreviews
@Composable
private fun CreatorsScreenPreview() = MarvelAppTheme {
    CreatorsScreen(
        state = CreatorsUiState(
            creators = null,
            screenState = ScreenState.LOADING
        ),
        onClickCreator = {}
    )
}
