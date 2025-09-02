package com.example.testapp.ui.features.home.presentation.screen

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DrawerValue
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testapp.R
import com.example.testapp.ui.features.home.Body
import com.example.testapp.ui.core.BottomNavigationBar
import com.example.testapp.ui.core.DestinationTopBar
import com.example.testapp.ui.navigation.Destination
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Home(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState)
    val orientation = LocalConfiguration.current.orientation
    val currentDestination by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry.value?.destination?.route?.let {
                Destination.fromString(it)
            } ?: run {
                Destination.Home
            }
        }
    }

    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            DestinationTopBar(
                destination =
                    currentDestination,
                onNavigateUp = {
                    navController.popBackStack()
                },
                onOpenDrawer = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                },
                showSnackbar = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState
                            .showSnackbar(it)
                    }
                }
            )
        },
        floatingActionButton = {
            if (   orientation != Configuration.ORIENTATION_LANDSCAPE &&
                currentDestination == Destination.Feed){
                FloatingActionButton(onClick = {
                    navController.navigate(
                        Destination.Add.path
                    )
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.cd_create_item)
                    )
                }
            }
        },
        bottomBar = {
            if (orientation != Configuration.ORIENTATION_LANDSCAPE && currentDestination.isRootDestination){
                BottomNavigationBar(
                    currentDestination = currentDestination,
                    onNavigate = {
                        navController.navigate(it.path) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        },
        drawerContent = {
            DrawerContent(
                modifier = Modifier.fillMaxWidth(),
                onNavigateSelected = { destination ->
                    navController.navigate(destination.path)
                    coroutineScope.launch {
                        drawerState.close()
                    }
                },
                onLogout = {
                 //logout
                }
            )
        }
        ) { padding ->
        Body(modifier = Modifier.fillMaxSize(),
            destination = currentDestination,
            orientation = orientation,
            navController = navController,
            onCreateItem = {
                navController.navigate(Destination.Add.path)
            },
            onNavigate = {
                navController.navigate(it.path){
                    popUpTo(Destination.Home.path){
                        saveState=true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}