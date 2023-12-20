package com.daaretodonor.ui.screen.profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daaretodonor.R
import com.daaretodonor.ui.components.ButtonEditProfil
import com.daaretodonor.ui.components.ButtonLogout
import com.daaretodonor.ui.theme.DaareToDonorTheme
import com.daaretodonor.ui.theme.MainColor

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 500.dp, width = 400.dp)
                .clip(
                    MaterialTheme.shapes.medium.copy(
                        topEnd = CornerSize(0.dp),
                        topStart = CornerSize(0.dp),
                    )
                )
                .background(MainColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.menu_profil),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.White)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "profil",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(7.dp)
                            .clip(MaterialTheme.shapes.medium),

                        )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Mochamad Ramdhan",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 30.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text(
                        text = "Bandung, Jawa Barat",
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                ButtonEditProfil()
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .padding(40.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .background(Color.White)
                            .wrapContentSize(Alignment.BottomCenter)
                    )
                    {
                        Text(
                            text = stringResource(R.string.gol_darah),
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .background(Color.White)
                            .wrapContentSize(Alignment.BottomCenter)
                    )
                    {
                        Text(
                            text = stringResource(R.string.count_donor),
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
            }
        }
        ButtonLogout()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    DaareToDonorTheme {
        ProfileScreen()
    }
}
