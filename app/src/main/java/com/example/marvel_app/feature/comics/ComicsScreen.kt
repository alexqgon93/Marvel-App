package com.example.marvel_app.feature.comics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.marvel_app.domain.models.comics.Comic
import com.example.marvel_app.domain.models.common.asString
import com.example.marvel_app.feature.comics.ScreenState.ERROR
import com.example.marvel_app.feature.comics.ScreenState.SUCCESS
import com.example.marvel_app.feature.comics.ScreenState.LOADING
import com.example.marvel_app.feature.common.ErrorView
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun ComicsScreenRoute(viewModel: ComicsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    ComicsScreen(state = state, onClickComic = {})
    LaunchedEffect(Unit) {
        viewModel.getComics()
    }
}

@Composable
fun ComicsScreen(state: ComicsUiState, onClickComic: (Comic) -> Unit) {
    when (state.screenState) {
        LOADING -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        SUCCESS -> LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(180.dp),
            contentPadding = PaddingValues(4.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            state.comics?.let { comics ->
                items(comics.size) { item ->
                    ComicItem(
                        comic = comics[item],
                        modifier = Modifier.clickable { onClickComic(comics[item]) })
                }
            }
        }

        ERROR -> ErrorView()
    }
}

@Composable
fun ComicItem(comic: Comic, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Card {
            AsyncImage(
                model = comic.thumbnail.asString(),
                contentDescription = comic.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Text(
                text = comic.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                modifier = Modifier.padding(8.dp, 16.dp)
            )
        }
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