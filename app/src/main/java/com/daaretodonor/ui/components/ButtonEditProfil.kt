package com.daaretodonor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daaretodonor.R
import com.daaretodonor.ui.theme.DaareToDonorTheme


@Composable
fun ButtonEditProfil(
) {
    Box(
        modifier = Modifier
            .size(height = 42.dp, width = 298.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.edit_profil),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaareToDonorTheme {
        ButtonEditProfil()
    }
}