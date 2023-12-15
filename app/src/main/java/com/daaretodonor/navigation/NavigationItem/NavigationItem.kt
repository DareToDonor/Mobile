package com.daaretodonor.navigation.NavigationItem

import androidx.annotation.DrawableRes


data class NavigationItem(
    val title: String,
    @DrawableRes val iconResourceId: Int? = null,
    val screen: Screen
)