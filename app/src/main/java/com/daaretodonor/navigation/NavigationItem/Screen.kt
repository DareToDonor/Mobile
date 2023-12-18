package com.daaretodonor.navigation.NavigationItem


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object News : Screen("news")
    object History : Screen("history")
    object Profile : Screen("profile")
}