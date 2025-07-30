package com.example.testapp.ui.features.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.testapp.R

@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onOptionSelected: (option: Theme) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    SettingItem (modifier = modifier){
        Row (modifier = Modifier
            .clickable (onClick = {expanded = !expanded},
                onClickLabel = stringResource(id = R.string.cd_select_theme)
            )
            .padding(16.dp)){
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.setting_option_theme)
            )
            Text(
                text = stringResource(id = selectedTheme.label)
            )
            DropdownMenu (
                expanded = expanded,
                onDismissRequest = {expanded = false},
                offset = DpOffset(16.dp,0.dp)
            ) {
                Theme.values().forEach { theme ->
                    DropdownMenuItem(
                        onClick = {
                            onOptionSelected(theme)
                            expanded = false
                        }
                    ){
                        Text(text = stringResource(id = theme.label))
                    }
                }
            }
        }
    }
}