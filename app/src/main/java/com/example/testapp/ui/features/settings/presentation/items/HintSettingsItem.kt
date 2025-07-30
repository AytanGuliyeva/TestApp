package com.example.testapp.ui.features.settings.presentation.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.ui.features.settings.presentation.components.SettingItem

@Composable
fun HintSettingsItem(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onShowHintsToggled: (checked: Boolean) -> Unit
) {
    val hintsEnabledState = if (checked) {
        stringResource(
            id =
                R.string.cd_hints_enabled
        )
    } else stringResource(
        id =
            R.string.cd_hints_disabled
    )

    SettingItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .toggleable(
                    value = checked,
                    onValueChange =
                        onShowHintsToggled,
                    role = Role.Checkbox
                )
                .semantics { stateDescription = hintsEnabledState }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, modifier = Modifier.weight(1f))
            Checkbox(
                checked = checked,
                onCheckedChange = null
            )
        }
    }

}