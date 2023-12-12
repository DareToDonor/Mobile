package com.daaretodonor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import androidx.navigation.compose.*
import com.daaretodonor.navigation.NavigationItem.NavigationItem
import com.daaretodonor.navigation.NavigationItem.Screen
import com.daaretodonor.ui.theme.DaareToDonorTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DareToDonor(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
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

            }
            composable(Screen.News.route) {

            }
            composable(Screen.Profile.route) {

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
    NavigationBar(
        modifier = modifier,
    ) {
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                iconResourceId =  R.drawable.ic_home,
            ),
            NavigationItem(
                title = stringResource(R.string.menu_news),
                iconResourceId = R.drawable.ic_news,
            ),
            NavigationItem(
                title = stringResource(R.string.menu_riwayat),
                iconResourceId =  R.drawable.ic_clock,
            ),
            NavigationItem(
                title = stringResource(R.string.menu_profil),
                iconResourceId =  R.drawable.ic_user,
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

                }
            )
        }

    }
}
