package com.daaretodonor.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daaretodonor.ui.screen.profil.ProfileScreen
import com.daaretodonor.ui.theme.DaareToDonorTheme
import com.daaretodonor.ui.theme.MainColor


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MainColor)
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaareToDonorTheme {
        HomeScreen()
    }
}