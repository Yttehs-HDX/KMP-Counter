package org.shettyyttehs.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.shettyyttehs.counter.ui.color.dynamicColorScheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = dynamicColorScheme()
            ) {
                SystemBarStyle()
                App()
            }
        }
    }
}

@Composable
fun SystemBarStyle() {
    @Suppress("DEPRECATION")
    val systemUiController = rememberSystemUiController()
    val isDarkMode = isSystemInDarkTheme()

    val statusBarColor = MaterialTheme.colorScheme.background
    val navigationBarColor = NavigationBarDefaults.containerColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = !isDarkMode,
        )
        systemUiController.setNavigationBarColor(
            color = navigationBarColor,
            darkIcons = !isDarkMode,
        )
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}