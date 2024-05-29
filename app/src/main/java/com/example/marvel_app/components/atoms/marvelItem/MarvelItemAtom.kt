package com.example.marvel_app.components.atoms.marvelItem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun MarvelItemAtom(model: MarvelItemModel, modifier: Modifier = Modifier) = with(model) {
    Column(modifier = modifier.padding(8.dp)) {
        Card {
            AsyncImage(
                model = thumbnail,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                modifier = modifier.padding(8.dp, 16.dp)
            )
        }
    }
}

@DevicePreviews
@Composable
fun MarvelItemAtomPreview() = MarvelAppTheme {
    MarvelItemAtom(
        model = MarvelItemModel(
            thumbnail = "https://via.placeholder.com/150",
            title = "Item 1"
        )
    )
}