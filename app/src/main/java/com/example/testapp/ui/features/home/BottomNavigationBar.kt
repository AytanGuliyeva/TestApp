package com.example.testapp.ui.features.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit
) {
    BottomNavigation(modifier = modifier) {
        /*    listOf(
                Destination.Feed,
                Destination.Contacts,
                Destination.Calendar
            )*/
        buildNavigationBarItems(currentDestination, onNavigate = onNavigate)
            .forEach {
                BottomNavigationItem(
                    selected = it.selected,
                    onClick = it.onClick,
                    icon = { it.icon() },
                    label = { it.label()}
                )
            }
    }
}