package com.daaretodonor.ui

import android.media.session.MediaSession.Token
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.daaretodonor.ui.screen.donor.Donor
import com.daaretodonor.ui.screen.history.HistoryScreen
import com.daaretodonor.ui.screen.home.HomeScreen
import com.daaretodonor.ui.screen.newsAndEvent.NewsAndEvent
import com.daaretodonor.ui.screen.profil.ProfileScreen
import com.daaretodonor.ui.screen.signup.SignUp
import com.daaretodonor.ui.screen.welcome.WelcomeScreen
import com.daaretodonor.ui.signin.SignIn
import com.daaretodonor.ui.theme.DaareToDonorTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DareToDonor(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val userPreference = UserPreference.getInstance(LocalContext.current.dataStore)
    val token by userPreference.getSession().collectAsState(initial = UserModel("", "", false))
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Log.d("token", "$token")
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Welcome.route && currentRoute != Screen.Donor.route && currentRoute != Screen.Login.route && currentRoute != Screen.Register.route) {
                BottomBar(navController = navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination =  if (token.isLogin) Screen.Home.route else Screen.Welcome.route ,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.News.route) {
                NewsAndEvent()
            }
            composable(Screen.History.route) {
                HistoryScreen()
            }
            composable(Screen.Donor.route) {
                Donor(navController = navController)
            }
            composable(Screen.Register.route) {
                SignUp(navController = navController)
            }


            composable(Screen.Welcome.route) {
                WelcomeScreen(navController = navController)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController = navController)
            }
            composable(Screen.Login.route) {
                SignIn(navController = navController)
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

