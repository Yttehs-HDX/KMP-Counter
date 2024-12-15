package org.shettyyttehs.counter

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.shettyyttehs.counter.ui.MainBottomBar
import org.shettyyttehs.counter.ui.MainContent

@Composable
@Preview
fun App() {
    val isDarkMode = isSystemInDarkTheme()

    MaterialTheme(
        colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme(),
    ) {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { MainBottomBar(navController) }
        ) {
            MainContent(navController)
        }
    }
}