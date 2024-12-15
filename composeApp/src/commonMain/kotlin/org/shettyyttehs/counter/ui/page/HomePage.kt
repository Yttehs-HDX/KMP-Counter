package org.shettyyttehs.counter.ui.page

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp

@Composable
fun HomePage(
    num: Long,
    onIncrement: () -> Unit,
) {
    val backgroundColor = MaterialTheme.colorScheme.background

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = backgroundColor,
            ),
        contentAlignment = Alignment.Center,
    ) {
        val circleColor = MaterialTheme.colorScheme.inversePrimary
        Canvas(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            drawCircle(
                color = circleColor,
                radius = size.minDimension / 5,
                center = Offset(size.width / 2, size.height / 2),
            )
        }

        Button(
            modifier = Modifier
                .padding(64.dp),
            onClick = onIncrement,
        ) {
            Text(
                text = "$num",
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}