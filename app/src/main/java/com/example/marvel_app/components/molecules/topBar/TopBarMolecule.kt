package com.example.marvel_app.components.molecules.topBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.marvel_app.R
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarMolecule(model: TopBarMoleculeModel) = with(model) {
    TopAppBar(
        title = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = model.title)
            }
        },
        navigationIcon = {
            if (enabledBackPressed) {
                IconButton(onClick = onBackClick, modifier = Modifier.size(32.dp)) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back),
                        tint = Color.White,
                        contentDescription = stringResource(R.string.back_icon_content_description)
                    )
                }
            } else Spacer(modifier = Modifier.size(32.dp))
        },
        actions = {
            Spacer(modifier = Modifier.size(32.dp))
        },
    )
}

@DevicePreviews
@Composable
private fun TopBarMoleculePreview() = MarvelAppTheme {
    TopBarMolecule(TopBarMoleculeModel("Title", {}))
}
