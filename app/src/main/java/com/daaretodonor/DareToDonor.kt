package com.daaretodonor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.daaretodonor.navigation.NavigationItem.NavigationItem
import com.daaretodonor.navigation.NavigationItem.Screen
import com.daaretodonor.ui.screen.history.HistoryScreen
import com.daaretodonor.ui.screen.home.HomeScreen
import com.daaretodonor.ui.screen.profil.ProfileScreen
import com.daaretodonor.ui.theme.DaareToDonorTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DareToDonor(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {

                BottomBar(navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.News.route) {

            }
            composable(Screen.History.route) {
                HistoryScreen()
            }
            composable(Screen.Profile.route) {
              ProfileScreen()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TargetLovePreview() {
    DaareToDonorTheme {
        DareToDonor()
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp) // Adjust the radius as needed
            )
            .shadow(3.dp)
    ) {
        NavigationBar(
            containerColor = Color.White,
            contentColor = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp)
        ) {
            val navigationItems = listOf(
                NavigationItem(
                    title = stringResource(R.string.menu_home),
                    iconResourceId = R.drawable.ic_home,
                    screen = Screen.Home
                ),
                NavigationItem(
                    title = stringResource(R.string.menu_news),
                    iconResourceId = R.drawable.ic_news,
                    screen = Screen.Profile
                ),
                NavigationItem(
                    title = stringResource(R.string.menu_riwayat),
                    iconResourceId = R.drawable.ic_clock,
                    screen = Screen.News
                ),
                NavigationItem(
                    title = stringResource(R.string.menu_profil),
                    iconResourceId = R.drawable.ic_user,
                    screen = Screen.Profile
                ),
            )
            navigationItems.map { item ->
                val icon = painterResource(id = item.iconResourceId!!)
                NavigationBarItem(
                    icon = {
                        Image(
                            painter = icon,
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text(item.title) },
                    selected = false,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }

        }
    }
}

