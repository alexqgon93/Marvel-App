package com.example.marvel_app.feature.characters

import androidx.compose.foundation.clickable
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
import com.example.marvel_app.components.atoms.marvelItem.MarvelItemAtom
import com.example.marvel_app.components.atoms.marvelItem.MarvelItemModel
import com.example.marvel_app.components.molecules.gridMolecule.GridItems
import com.example.marvel_app.domain.models.characters.Character
import com.example.marvel_app.domain.models.common.Image
import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.asString
import com.example.marvel_app.feature.common.ErrorView
import com.example.marvel_app.ui.theme.MarvelAppTheme
import com.example.marvel_app.feature.characters.ScreenState.ERROR
import com.example.marvel_app.feature.characters.ScreenState.SUCCESS
import com.example.marvel_app.feature.characters.ScreenState.LOADING
import com.example.marvel_app.ui.DevicePreviews

@Composable
fun CharactersScreenRoute(
    viewModel: CharactersViewModel = hiltViewModel(),
    onClickCharacter: (Character) -> Unit,
) {
    val state by viewModel.state.collectAsState()
    CharactersScreen(state = state, onClickCharacter = onClickCharacter)
//    LaunchedEffect(Unit) {
//        viewModel.getCharacters()
//    }
}

@Composable
fun CharactersScreen(state: CharactersUiState, onClickCharacter: (Character) -> Unit) =
    when (state.screenState) {
        ERROR -> ErrorView()
        LOADING -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        SUCCESS -> GridItems(state.characters ?: emptyList()) { character ->
            MarvelItemAtom(
                model = MarvelItemModel(
                    thumbnail = character.thumbnail.asString(),
                    title = character.name
                ),
                modifier = Modifier.clickable { onClickCharacter(character) }
            )
        }
    }


@DevicePreviews
@Composable
fun CharactersScreenPreview() = MarvelAppTheme {
    CharactersScreen(
        state = CharactersUiState(
            screenState = SUCCESS, characters = (1..10).map {
                Character(
                    comics = Items(
                        available = 6302,
                        collectionURI = "volumus",
                        items = listOf(),
                        returned = 3182
                    ),
                    description = "falli",
                    events = Items(
                        available = 1940,
                        collectionURI = "alterum",
                        items = listOf(),
                        returned = 3480
                    ),
                    id = 7984,
                    modified = "elitr",
                    name = "Jimmie Reilly",
                    resourceURI = "mnesarchum",
                    series = Items(
                        available = 1866,
                        collectionURI = "metus",
                        items = listOf(),
                        returned = 9089
                    ),
                    stories = Items(
                        available = 1754,
                        collectionURI = "dolor",
                        items = listOf(),
                        returned = 4695
                    ),
                    thumbnail = Image(
                        extension = "scripserit",
                        path = "sem"
                    ),
                    urls = listOf()
                )
            }
        ), onClickCharacter = {}
    )
}