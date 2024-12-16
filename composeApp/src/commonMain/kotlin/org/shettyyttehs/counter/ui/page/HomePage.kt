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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import org.shettyyttehs.counter.ui.NumberViewModel

@Composable
fun HomePage(numberViewModel: NumberViewModel) {
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

        val currentNumber by numberViewModel.currentNumber.collectAsState()

        Button(
            modifier = Modifier
                .padding(64.dp),
            onClick = {
                numberViewModel.increaseNumber()
            },
        ) {
            Text(
                text = "$currentNumber",
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}