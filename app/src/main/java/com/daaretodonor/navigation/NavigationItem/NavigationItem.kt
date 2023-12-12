package com.daaretodonor.navigation.NavigationItem

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector


data class NavigationItem(
    val title: String,
    @DrawableRes val iconResourceId: Int? = null
)