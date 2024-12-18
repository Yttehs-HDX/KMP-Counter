package org.shettyyttehs.counter

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.shettyyttehs.counter.ui.MainBottomBar
import org.shettyyttehs.counter.ui.MainContent
import org.shettyyttehs.counter.ui.color.dynamicColorScheme

@Composable
@Preview
fun App() {
    MaterialTheme(
        colorScheme = dynamicColorScheme()
    ) {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { MainBottomBar(navController) }
        ) {
            MainContent(navController)
        }
    }
}