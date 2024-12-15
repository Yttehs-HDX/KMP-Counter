package org.shettyyttehs.counter.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import org.shettyyttehs.counter.MainDestination
import org.shettyyttehs.counter.MainDestinationDefault
import org.shettyyttehs.counter.extend.navigateSingleTop

@Composable
fun MainBottomBar(navController: NavHostController) {
    NavigationBar {
        var currentRoute by remember { mutableStateOf(MainDestinationDefault.Route) }

        for (item in MainDestination.Items) {
            NavigationBarItem(
                selected = currentRoute == item.route,
                alwaysShowLabel = currentRoute == item.route,
                onClick = {
                    currentRoute = item.route
                    navController.navigateSingleTop(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                    )
                },
                label = {
                    Text(
                        text = item.label,
                    )
                },
            )
        }
    }
}