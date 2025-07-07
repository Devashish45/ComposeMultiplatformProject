package org.example.home.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TrendingMoviesScreen(
    modifier: Modifier = Modifier,
    onFavouriteClick: () -> Unit
) {
    val viewModel = koinViewModel<TrendingMoviesViewModel>()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    TrendingMoviesScreenContent(
        modifier = modifier.fillMaxSize(),
        uiState = uiState.value,
        onFavouriteClick = onFavouriteClick
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendingMoviesScreenContent(
    modifier: Modifier = Modifier,
    uiState: HomeScreen.UiState,
    onFavouriteClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Trending") },
                actions = {
                    IconButton(onClick = onFavouriteClick) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        }) { paddingValues ->
        Column {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                if (uiState.isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                if (uiState.error.isNotBlank()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(uiState.error)
                    }
                }

                uiState.trendingMovies.let { data ->
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(data) {
                            Card(
                                modifier = Modifier.padding(8.dp),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxSize()
                                        .background(color = Color.Cyan)
                                ) {
                                    Box {
                                        AsyncImage(
                                            model = it.poster_path,
                                            contentDescription = null
                                        )
                                    }
                                    Text(
                                        it.title,
                                        style = MaterialTheme.typography
                                            .headlineLarge
                                    )
                                }
                            }
                        }
                    }
                }
                Button(
                    onClick = {},
                    content = {
                        Text(
                            "Button",
                            style = MaterialTheme.typography.labelMedium
                        )
                    })
            }
        }
    }
}