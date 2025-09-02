package com.example.testapp.ui.features.home.presentation.components

import androidx.compose.material.Text
import androidx.compose.material3.Icon
import com.example.testapp.ui.features.home.data.NavigationBarItem
import com.example.testapp.ui.navigation.Destination
import java.util.Locale

fun buildNavigationBarItems(
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit)
: List<NavigationBarItem> {
    return listOf(
        Destination.Feed,
        Destination.Contacts,
        Destination.Calendar
    ).map {
        NavigationBarItem(
            selected = currentDestination.path == it.path,
            onClick = {onNavigate(it)},
            icon = {
                it.icon?.let { image ->
                    Icon(imageVector = image,
                        contentDescription = null)
                }
            },
            label = {
                Text(text =
                    it.path.replaceFirstChar { char ->
                        char.titlecase(Locale.getDefault())
                    }
                )
            }
        )
    }
}