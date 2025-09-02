package com.example.testapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
    val path: String,
    val icon: ImageVector? = null,
    val isRootDestination: Boolean = true
) {
    companion object {
        fun fromString(route: String?): Destination {
            return when (route) {
                Feed.path -> Feed
                Calendar.path -> Calendar
                Contacts.path -> Contacts
                Upgrade.path -> Upgrade
                Settings.path -> Settings
                Add.path -> Add
                Creation.path -> Creation
                else -> Home
            }
        }
    }

    data object Home : Destination("home")
    data object Feed : Destination("feed", Icons.Default.List)
    data object Contacts : Destination("contacts", Icons.Default.Person)
    data object Calendar : Destination("gallery", Icons.Default.DateRange)
    data object Settings : Destination("settings", Icons.Default.Settings)
    data object Upgrade : Destination("upgrade", Icons.Default.Star)
    data object Creation : Destination("creation", isRootDestination = false)
    data object Add : Destination("add", Icons.Default.Add, isRootDestination = false)
}