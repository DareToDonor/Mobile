package com.daaretodonor.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.daaretodonor.R
import com.daaretodonor.model.UserModel
import com.daaretodonor.model.UserPreference
import com.daaretodonor.model.dataStore
import com.daaretodonor.navigation.NavigationItem.NavigationItem
import com.daaretodonor.navigation.NavigationItem.Screen
import com.daaretodonor.ui.screen.history.HistoryScreen
import com.daaretodonor.ui.screen.home.HomeScreen
import com.daaretodonor.ui.screen.newsAndEvent.NewsAndEvent
import com.daaretodonor.ui.screen.profil.ProfileScreen
import com.daaretodonor.ui.screen.signup.SignUp
import com.daaretodonor.ui.screen.welcome.WelcomeScreen
import com.daaretodonor.ui.signin.SignIn
import com.daaretodonor.ui.theme.DaareToDonorTheme


@Composable
fun DareToDonor() {
    val navController = rememberNavController()
    val userPreference = UserPreference.getInstance(LocalContext.current.dataStore)
    val token by userPreference.getSession().collectAsState(initial = UserModel("", "", false))

    DaareToDonorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (token.isLogin) {
                Aplication(navController)
            } else {
                NavHost(navController = navController, startDestination = Screen.Welcome.route) {
                    composable(Screen.Welcome.route) {
                        WelcomeScreen(navController = navController)
                    }
                    composable(Screen.Login.route) {
                        SignIn(navController = navController)
                    }
                    composable(Screen.Register.route) {
                        SignUp(navController = navController)
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Aplication(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        modifier = Modifier.fillMaxSize()
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
                NewsAndEvent()
            }
            composable(Screen.History.route) {
                HistoryScreen()
            }
            composable(Screen.Welcome.route) {
                WelcomeScreen(navController = navController)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DareToDonorPreview() {
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
            .border(width = 1.dp, color = Color.Gray)
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            contentColor = Color.Black,
            containerColor = Color.Transparent,
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
                    screen = Screen.News
                ),
                NavigationItem(
                    title = stringResource(R.string.menu_riwayat),
                    iconResourceId = R.drawable.ic_clock,
                    screen = Screen.History
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

