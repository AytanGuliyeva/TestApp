package com.example.testapp.ui.features.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.testapp.ui.navigation.Destination
import com.example.testapp.ui.navigation.Navigation
import com.example.testapp.ui.core.RailNavigationBar

@Composable
fun Body(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    destination: Destination,
    orientation: Int,
    onCreateItem: () -> Unit,
    onNavigate: (destination: Destination) -> Unit
) {
    Row(modifier = modifier) {
        if (destination.isRootDestination && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            RailNavigationBar(
                modifier = modifier,
                currentDestination = destination,
                onCreateItem = onCreateItem,
                onNavigate = onNavigate
            )
        }
        Navigation(
            modifier = Modifier.fillMaxSize(),
            navController = navController
        )
    }
}