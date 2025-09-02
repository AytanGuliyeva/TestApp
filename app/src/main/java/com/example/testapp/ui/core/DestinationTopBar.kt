package com.example.testapp.ui.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testapp.ui.navigation.Destination

@Composable
fun DestinationTopBar(
    modifier: Modifier = Modifier,
    destination: Destination,
    onNavigateUp: () -> Unit,
    onOpenDrawer: () -> Unit,
    showSnackbar: (message: String) -> Unit
    ){

    if (destination.isRootDestination){
        RootDestinationTopBar(
            modifier = modifier,
            currentDestination = destination,
            openDrawer = onOpenDrawer,
            showSnackbar = showSnackbar
        )
    }else{
        ChildDestinationTopBar(
            modifier = modifier,
            onNavigateUp = onNavigateUp,
            title = destination.path
        )
    }
}