package com.daaretodonor.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 12.dp, end = 12.dp)
            .border(3.dp, Color.Black .copy(0.5f), MaterialTheme.shapes.small)
    ) {
        Box(
            modifier = Modifier
                .size(height = 200.dp , width = 400.dp)
                .background(Color.White)
        )
    }
}