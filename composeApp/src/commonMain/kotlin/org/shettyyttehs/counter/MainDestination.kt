package org.shettyyttehs.counter

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface MainDestination {
    val route: String
    val icon: ImageVector
    val label: String

    companion object {
        val Items = listOf(Home, About)
    }

    data object Home : MainDestination {
        override val route = "home"
        override val icon = Icons.Filled.Home
        override val label = "Home"
    }

    data object About : MainDestination {
        override val route = "about"
        override val icon = Icons.Filled.Info
        override val label = "About"
    }
}

object MainDestinationDefault {
    val Route = MainDestination.Home.route
}