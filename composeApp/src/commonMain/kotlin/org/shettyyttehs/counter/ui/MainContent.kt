package org.shettyyttehs.counter.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.shettyyttehs.counter.MainDestination
import org.shettyyttehs.counter.MainDestinationDefault
import org.shettyyttehs.counter.cache.databaseFactory
import org.shettyyttehs.counter.ui.page.AboutPage
import org.shettyyttehs.counter.ui.page.HomePage

@Composable
fun MainContent(navController: NavHostController) {
    val numberViewModel = viewModel { NumberViewModel(databaseFactory) }
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = MainDestinationDefault.Route,
    ) {
        composable(route = MainDestination.Home.route) {
            HomePage(numberViewModel)
        }
        composable(route = MainDestination.About.route) {
            AboutPage()
        }
    }
}