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
import androidx.navigation.NavHostController
import com.daaretodonor.R
import com.daaretodonor.navigation.NavigationItem.Screen

@Composable
fun ButtonCreateAccount(
    navController: NavHostController,
) {
    Button(
        onClick = {
            navController.navigate(Screen.Register.route)
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