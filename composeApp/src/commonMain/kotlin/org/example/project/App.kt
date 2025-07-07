package org.example.project

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.example.project.navigation.MoviesNavGraph
import org.example.project.theme.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Theme {
        val navHostController = rememberNavController()
        NavHost(
            navController = navHostController,
            startDestination = MoviesNavGraph.Dest.Root.route
        ) {
            listOf(
                MoviesNavGraph
            ).forEach {
                it.build(
                    modifier = Modifier.fillMaxSize(),
                    navHostController = navHostController,
                    navGraphBuilder = this
                )
            }
        }
    }
}