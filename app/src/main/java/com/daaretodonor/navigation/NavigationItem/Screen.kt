package com.daaretodonor.navigation.NavigationItem


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object News : Screen("news")
    object History : Screen("history")
    object Profile : Screen("profile")
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Register : Screen("register")
    object Donor : Screen("donor")
    object DateSelection : Screen("dataselection")
}