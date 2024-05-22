package com.example.marvel_app.feature.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.marvel_app.domain.models.characters.Character
import com.example.marvel_app.domain.models.common.Image
import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.Stories
import com.example.marvel_app.domain.models.common.asString
import com.example.marvel_app.feature.common.ErrorView
import com.example.marvel_app.ui.theme.MarvelAppTheme
import com.example.marvel_app.feature.characters.ScreenState.ERROR
import com.example.marvel_app.feature.characters.ScreenState.SUCCESS
import com.example.marvel_app.feature.characters.ScreenState.LOADING

@Composable
fun CharactersScreenRoute(
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    CharactersScreen(state = state)
    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }
}

@Composable
fun CharactersScreen(
    state: CharactersUiState,
) {
    when (state.screenState) {
        ERROR -> ErrorView()
        LOADING -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        SUCCESS ->
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(180.dp),
                contentPadding = PaddingValues(4.dp),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                state.characters?.let { characters ->
                    items(characters.size) { item ->
                        CharacterItem(character = characters[item])
                    }
                }
            }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Column(modifier = Modifier.padding(8.dp)) {
        Card {
            AsyncImage(
                model = character.thumbnail.asString(),
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Text(
                text = character.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                modifier = Modifier.padding(8.dp, 16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
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
                    series = Stories(
                        available = 1866,
                        collectionURI = "metus",
                        items = listOf(),
                        returned = 9089
                    ),
                    stories = Stories(
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
        )
    )
}