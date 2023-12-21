package com.daaretodonor.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.daaretodonor.R
import com.daaretodonor.model.UserPreference
import com.daaretodonor.model.dataStore
import com.daaretodonor.navigation.NavigationItem.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun ButtonLogout(navController: NavHostController) {
    val context = LocalContext.current
    val userPreference = remember { UserPreference.getInstance(context.dataStore) }

    LaunchedEffect(true) {
        if (!userPreference.getSession().first().isLogin) {
            navController.navigate(Screen.Welcome.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    Button(
        onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                userPreference.logout()
            }
        },
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(4.dp)
            .size(height = 42.dp, width = 400.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.logout),
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}
