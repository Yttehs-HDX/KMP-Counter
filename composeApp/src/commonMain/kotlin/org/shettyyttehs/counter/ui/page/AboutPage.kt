package org.shettyyttehs.counter.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kmp_counter.composeapp.generated.resources.Res
import kmp_counter.composeapp.generated.resources.ic_launcher_round
import org.jetbrains.compose.resources.painterResource

@Composable
fun AboutPage() {
    val backgroundColor = MaterialTheme.colorScheme.background

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(
                color = backgroundColor,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .clickable { }
        ) {
            Row(
                modifier = Modifier
                    .padding(32.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_launcher_round),
                    contentDescription = "Counter Icon",
                )
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
                Column {
                    Text(
                        text = "Counter",
                        style = MaterialTheme.typography.displayMedium,
                    )
                    Text(
                        text = "By Yttehs-HDX@Github",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        InfoItem(
            icon = Icons.Default.Star,
            info = "github.com/Yttehs-HDX/Counter",
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        InfoItem(
            icon = Icons.Default.Build,
            info = "Version 1.0.0",
        )
    }
}

@Composable
fun InfoItem(
    onclick: () -> Unit = { },
    icon: ImageVector,
    info: String,
) {
    Card(
        modifier = Modifier
            .clickable { onclick() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Text(text = info)
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}