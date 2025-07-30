package com.example.testapp.ui.features.settings.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testapp.R
import com.example.testapp.ui.features.settings.presentation.items.AppVersionSettingItem
import com.example.testapp.ui.features.settings.presentation.items.HintSettingsItem
import com.example.testapp.ui.features.settings.presentation.items.ManageSubscriptionSettingItem
import com.example.testapp.ui.features.settings.presentation.items.MarketingSettingItem
import com.example.testapp.ui.features.settings.presentation.items.NotificationsSettings
import com.example.testapp.ui.features.settings.presentation.components.SectionSpacer
import com.example.testapp.ui.features.settings.presentation.items.ThemeSettingItem

@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()
    val state = viewModel.uiState.collectAsState().value

    MaterialTheme {
        Column {
            SettingsList()
            NotificationsSettings(
                Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.setting_enable_notifications),
                checked = state.notificationsEnabled,
                onCheckedChanged = viewModel::toggleNotificationSettings
            )
            Divider()
            HintSettingsItem(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.setting_show_hints),
                checked = state.hintsEnabled,
                onShowHintsToggled = viewModel::toggleHintSettings
            )
            Divider()
            ManageSubscriptionSettingItem(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(id = R.string.setting_manage_subscription),
                onSettingClicked = { }
            )
            SectionSpacer(modifier = Modifier.fillMaxWidth())

            MarketingSettingItem(
                modifier = Modifier.fillMaxWidth(),
                selectedOption = state.marketingOption,
                onOptionSelected = viewModel::setMarketingSettings
            )
            Divider()
            ThemeSettingItem(
                modifier = Modifier.fillMaxWidth(),
                selectedTheme = state.themeOption,
                onOptionSelected = viewModel::setTheme
            )
            SectionSpacer(modifier = Modifier.fillMaxWidth())

            AppVersionSettingItem(
                modifier = Modifier.fillMaxWidth(),
                appVersion = stringResource(id = R.string.setting_app_version)
            )
            Divider()
        }

    }
}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        androidx.compose.material.TopAppBar(
            backgroundColor = MaterialTheme.colorScheme.surface,
            contentPadding = PaddingValues(start = 12.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.cd_go_back)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.title_settings),
                color = MaterialTheme.colorScheme.onSurface, fontSize = 18.sp
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    Settings()
}