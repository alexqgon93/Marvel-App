package com.example.marvel_app.feature.events

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
import com.example.marvel_app.domain.models.events.Event
import com.example.marvel_app.feature.ScreenState.ERROR
import com.example.marvel_app.feature.ScreenState.LOADING
import com.example.marvel_app.feature.ScreenState.SUCCESS
import com.example.marvel_app.feature.common.ErrorView
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun EventsScreenRoute(viewModel: EventsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    EventsScreen(state = state, onClickEvent = {})
}

@Composable
fun EventsScreen(state: EventsUiState, onClickEvent: (Event) -> Unit) = when (state.screenState) {
    LOADING -> Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }

    SUCCESS -> GridItems(state.events ?: emptyList()) { event ->
        MarvelItemAtom(
            model = MarvelItemModel(
                thumbnail = event.thumbnail.asString(),
                title = event.title
            ),
            modifier = Modifier.clickable { onClickEvent(event) }
        )
    }

    ERROR -> ErrorView()
}

@DevicePreviews
@Composable
fun EventsScreenPreview() = MarvelAppTheme {
    EventsScreen(state = EventsUiState(screenState = SUCCESS),
        onClickEvent = {})
}