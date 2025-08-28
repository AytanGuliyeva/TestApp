package com.example.testapp.ui.features.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.Home.path
    ) {
        navigation(
            startDestination = Destination.Feed.path,
            route = Destination.Home.path
        ) {
            composable(route = Destination.Feed.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Feed
                )
            }
            composable(Destination.Contacts.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Contacts
                )
            }
            composable(Destination.Calendar.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Calendar
                )
            }
            composable(Destination.Upgrade.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Upgrade
                )
            }
            composable(Destination.Settings.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Settings
                )
            }
            composable(Destination.Settings.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Settings
                )
            }
            composable(
                Destination.Add.path
            ) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Add
                )
            }
        }
    }
}

//navigation(
//startDestination =
//Destination.Add.path,
//route = Destination.Creation.path
//) {
//    composable(route =
//        Destination.Add.path) {
//        ContentArea( modifier =
//            Modifier.fillMaxSize(),
//            destination =
//                Destination.Add
//        )
//    }
//}