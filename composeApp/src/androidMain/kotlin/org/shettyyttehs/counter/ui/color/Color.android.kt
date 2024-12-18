package org.shettyyttehs.counter.ui.color

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import org.shettyyttehs.counter.MyApplication

@Composable
actual fun dynamicColorScheme(): ColorScheme {
    val (darkColorScheme, lightColorScheme) = when {
        Build.VERSION.SDK_INT < Build.VERSION_CODES.S ->
            (darkColorScheme() to lightColorScheme())
        else -> {
            val context = MyApplication.Context
            (dynamicDarkColorScheme(context) to dynamicLightColorScheme(context))
        }
    }

    return if (isSystemInDarkTheme()) {
        darkColorScheme
    } else {
        lightColorScheme
    }
}