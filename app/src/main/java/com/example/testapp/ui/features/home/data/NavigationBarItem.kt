package com.example.testapp.ui.features.home.data

import androidx.compose.runtime.Composable

class NavigationBarItem(
    val selected: Boolean,
    val onClick: () -> Unit,
    val icon: @Composable () -> Unit,
    val label: @Composable () -> Unit
)