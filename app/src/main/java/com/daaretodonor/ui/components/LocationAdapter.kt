package com.daaretodonor.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.daaretodonor.data.response.locationhospital.Location
import com.daaretodonor.ui.theme.DaareToDonorTheme

@Composable
fun LocationAdapter(
    modifier: Modifier = Modifier,
    location: Location,
    selectedLocationId: Int?,
    onItemClick: (Int) -> Unit
) {
    val isSelected = location.id == selectedLocationId
    DaareToDonorTheme {
        Box(
            modifier = modifier
                .shadow(1.dp)
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(if (isSelected) Color.LightGray else Color.White),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = modifier
                    .padding(8.dp)
                    .clickable {
                        onItemClick(location.id)
                    },

            ) {
                Box(
                    modifier = Modifier
                        .size(115.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.Gray)
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = location.image,
                            builder = {
                                scale(Scale.FILL)
                            }
                        ),
                        contentDescription = "image_player",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = location.name,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = location.address,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                    )
                }
            }
        }

    }

}


