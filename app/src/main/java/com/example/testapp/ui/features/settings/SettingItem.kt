package com.example.testapp.ui.features.settings

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun SettingItem(
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
){
    Surface(modifier = modifier.heightIn(min = 56.dp)) {
        content()
    }
}