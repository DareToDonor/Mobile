package com.daaretodonor.ui.screen.newsAndEvent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daaretodonor.R
import com.daaretodonor.ui.theme.DaareToDonorTheme
import com.daaretodonor.ui.theme.MainColor

@Composable
fun NewsAndEvent() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.newsandevent),
            fontWeight = FontWeight.ExtraBold,
            color = MainColor,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(4.dp)
                        .width(16.dp),
                    color = MainColor
                )
            },
            contentColor = Color.White
        ) {
            Tab(
                text = {
                    Text(
                        stringResource(R.string.news),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = if (selectedTabIndex == 0) MainColor else Color.Black
                    )
                },
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 }
            )
            Tab(
                text = {
                    Text(
                        stringResource(R.string.event),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = if (selectedTabIndex == 1) MainColor else Color.Black
                    )
                },
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 }
            )
        }

        when (selectedTabIndex) {
            0 -> TabContent("Tab 1 Content")
            1 -> TabContent("Tab 2 Content")
        }
    }
}

@Composable
fun TabContent(content: String) {
    Text(text = content, modifier = Modifier.fillMaxSize())
}

@Preview(showBackground = true)
@Composable
fun NewsAndEventPreview() {
    DaareToDonorTheme {
        NewsAndEvent()
    }
}
