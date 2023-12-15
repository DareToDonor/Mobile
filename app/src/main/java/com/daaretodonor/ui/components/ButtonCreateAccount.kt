package com.daaretodonor.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.daaretodonor.R

@Composable
fun ButtonCreateAccount (){
    Button(
        onClick = {
        },
        colors = ButtonDefaults.buttonColors(Color.White),
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.create_account),
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
    }
}