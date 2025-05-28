package org.example.project.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.example.home.ui.home.TrendingMoviesScreen

object MoviesNavGraph : BaseNavGraph {

    sealed class Dest(val route: String) {
        data object Root : Dest("/movies-root")
        data object TrendingMovies : Dest("/trending-movies")
    }

    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            route = Dest.Root.route,
            startDestination = Dest.TrendingMovies.route
        ) {
            composable(route = Dest.TrendingMovies.route){
                TrendingMoviesScreen(modifier = Modifier.fillMaxSize(), onFavouriteClick = {
                    navHostController.navigate(Dest.TrendingMovies.route)
                })
            }
        }
    }
}