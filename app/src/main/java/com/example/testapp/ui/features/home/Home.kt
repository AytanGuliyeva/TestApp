package com.example.testapp.ui.features.home

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DrawerValue
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
                /*
                        topBar = {
                            val snackBarMessage = stringResource(id = R.string.not_available_yet)
                            TopAppBar(
                                title = { Text(text = Destination.Home.path) },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        coroutineScope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(imageVector = Icons.Default.Menu,
                                            contentDescription = stringResource(id = R.string.cd_open_menu)
                                        )
                                    }
                                },
                                actions = {
                                    if (currentDestination != Destination.Feed) {
                                        IconButton(onClick = {
                                            coroutineScope.launch {
                                                scaffoldState.snackbarHostState.showSnackbar(snackBarMessage)
                                            }
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Info,
                                                contentDescription = stringResource(id = R.string.cd_more_information)
                                            )
                                        }
                                    }
                                }

                            )
                        },
                */
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
                    })

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
            })
        Navigation(
            modifier = modifier,
            navController = navController
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}