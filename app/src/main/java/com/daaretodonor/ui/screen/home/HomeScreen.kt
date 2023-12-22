package com.daaretodonor.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.daaretodonor.R
import com.daaretodonor.navigation.NavigationItem.Screen
import com.daaretodonor.ui.theme.MainColor


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MainColor)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(start = 5.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .size(width = 330.dp, height = 245.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .wrapContentSize(Alignment.BottomCenter)
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 80.dp, height = 20.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.Black)
                        .wrapContentSize(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .size(width = 330.dp, height = 110.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .wrapContentSize(Alignment.BottomCenter)
                    .clickable {
                        navController.navigate(Screen.DateSelection.route)
                    }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_blood),
                        contentDescription = "image welcome",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Text(
                        text = stringResource(R.string.start_donor),
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    text = stringResource(R.string.popular_news),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    textDecoration = TextDecoration.Underline,
                    text = stringResource(R.string.show_all),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
            }
        }
    }
}
