package com.example.testapp.ui.core

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.testapp.R
import com.example.testapp.ui.features.home.presentation.components.buildNavigationBarItems
import com.example.testapp.ui.navigation.Destination

@Composable
fun RailNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onCreateItem: () -> Unit,
    onNavigate: (destination: Destination) -> Unit
) {
    NavigationRail(header = {
        FloatingActionButton(onClick = {
            onCreateItem()
        }) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.cd_create_item)
            )
        }
    }) {
        buildNavigationBarItems(
            currentDestination = currentDestination,
            onNavigate = onNavigate
        ).map {
            NavigationRailItem(
                selected = it.selected,
                onClick = it.onClick,
                icon = { it.icon() },
                label = { it.label() }
            )
        }
    }
}