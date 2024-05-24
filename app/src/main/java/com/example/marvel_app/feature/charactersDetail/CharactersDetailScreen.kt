package com.example.marvel_app.feature.charactersDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.marvel_app.domain.models.characters.Character
import com.example.marvel_app.domain.models.common.Item
import com.example.marvel_app.domain.models.common.asString
import com.example.marvel_app.feature.common.ErrorView
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun CharactersDetailScreenRoute(viewModel: CharactersDetailViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    CharactersDetailScreen(state = state)
}

@Composable
fun CharactersDetailScreen(state: CharactersDetailUiState) {
    when (state.screenState) {
        ScreenState.LOADING -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        ScreenState.ERROR -> ErrorView()
        ScreenState.SUCCESS ->
            state.character?.let { character ->
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        CharacterDetailItem(character = character)
                    }
                    if (character.series.items.isNotEmpty())
                        section(Icons.Default.Home, "Series", character.series.items)
                    if (character.events.items.isNotEmpty())
                        section(Icons.Default.AccountBox, "Events", character.events.items)
                    if (character.comics.items.isNotEmpty())
                        section(Icons.Default.AccountBox, "Comics", character.comics.items)
                    if (character.stories.items.isNotEmpty())
                        section(Icons.Default.AccountBox, "Stories", character.stories.items)
                }
            }
    }
}

fun LazyListScope.section(icon: ImageVector, title: String, items: List<Item>) {
    item {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp, 0.dp)
        )
    }
    items(items.size) {
        ListItem(
            headlineContent = { Text(text = items[it].name) },
            leadingContent = { Icon(icon, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
private fun CharacterDetailItem(character: Character) = Column(
    modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.spacedBy(16.dp)
) {
    AsyncImage(
        model = character.thumbnail.asString(),
        contentDescription = character.name,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .aspectRatio(1f)
    )
    Text(
        text = character.name,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
    )
    Text(
        text = character.description,
        textAlign = TextAlign.Justify,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
    )
}

@DevicePreviews
@Composable
private fun CharactersDetailScreenPreview() = MarvelAppTheme {
    CharactersDetailScreen(state = CharactersDetailUiState())
}