package com.example.testapp.ui.core

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testapp.ui.features.home.presentation.components.buildNavigationBarItems
import com.example.testapp.ui.navigation.Destination

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit
) {
    BottomNavigation(modifier = modifier) {
        buildNavigationBarItems(currentDestination, onNavigate = onNavigate)
            .forEach {
                BottomNavigationItem(
                    selected = it.selected,
                    onClick = it.onClick,
                    icon = { it.icon()},
                    label = { it.label()}
                )
            }
    }
}