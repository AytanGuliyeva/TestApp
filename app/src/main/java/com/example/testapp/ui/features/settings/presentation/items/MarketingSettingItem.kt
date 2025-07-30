package com.example.testapp.ui.features.settings.presentation.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.ui.features.settings.domain.model.MarketingOption
import com.example.testapp.ui.features.settings.presentation.components.SettingItem

@Composable
fun MarketingSettingItem(
    modifier: Modifier = Modifier,
    selectedOption: MarketingOption,
    onOptionSelected: (option: MarketingOption) -> Unit,
) {
    val option = stringArrayResource(id = R.array.setting_options_marketing_choice)

    SettingItem(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.setting_option_marketing)
            )
            Spacer(modifier = Modifier.height(8.dp))
            option.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = selectedOption.id == index,
                            onClick = {
                                val marketingOption =
                                    if (index == MarketingOption.ALLOWED.id) {
                                        MarketingOption.ALLOWED
                                    } else
                                        MarketingOption.NOT_ALLOWED
                                onOptionSelected(marketingOption)
                            },
                            role = Role.RadioButton
                        )
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    RadioButton(
                        selected = selectedOption.id == index,
                        onClick = null
                    )
                    Text(
                        modifier = Modifier.padding(
                            start = 18.dp
                        ),
                        text = option
                    )
                }
            }
        }
    }
}