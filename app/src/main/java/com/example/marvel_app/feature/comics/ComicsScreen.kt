package com.example.marvel_app.feature.comics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvel_app.components.atoms.marvelItem.MarvelItemAtom
import com.example.marvel_app.components.atoms.marvelItem.MarvelItemModel
import com.example.marvel_app.components.molecules.gridMolecule.GridItems
import com.example.marvel_app.domain.models.comics.Comic
import com.example.marvel_app.domain.models.common.asString
import com.example.marvel_app.feature.ScreenState.ERROR
import com.example.marvel_app.feature.ScreenState.SUCCESS
import com.example.marvel_app.feature.ScreenState.LOADING
import com.example.marvel_app.feature.common.ErrorView
import com.example.marvel_app.feature.toStringRes
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme
import kotlinx.coroutines.launch

@Composable
fun ComicsScreenRoute() = ComicsScreen(onClickComic = {})

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComicsScreen(viewModel: ComicsViewModel = hiltViewModel(), onClickComic: (Comic) -> Unit) {
    val formats = Comic.Format.entries.toList()
    val pagerState = rememberPagerState(pageCount = { formats.size })
    val scope = rememberCoroutineScope()

    Column {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp,
        ) {
            formats.forEach { format ->
                Tab(
                    selected = format.ordinal == pagerState.currentPage,
                    onClick = { scope.launch { pagerState.animateScrollToPage(format.ordinal) } },
                    text = { Text(text = stringResource(id = format.toStringRes()).uppercase()) })
            }
        }
        HorizontalPager(state = pagerState, beyondBoundsPageCount = 0) { page ->
            val format = formats[page]
            viewModel.formatRequested(format)
            val pageState by viewModel.state.getValue(format).collectAsState()
            when (pageState.screenState) {
                LOADING -> Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                ERROR -> ErrorView()

                SUCCESS -> GridItems(pageState.comics) { comic ->
                    MarvelItemAtom(
                        model = MarvelItemModel(
                            thumbnail = comic.thumbnail.asString(),
                            title = comic.title
                        ),
                        modifier = Modifier.clickable { onClickComic(comic) })
                }
            }
        }
    }
}

@DevicePreviews
@Composable
private fun ComicsScreenPreview() = MarvelAppTheme { ComicsScreen(onClickComic = {}) }