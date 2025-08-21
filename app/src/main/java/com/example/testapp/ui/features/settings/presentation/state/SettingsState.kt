package com.example.testapp.ui.features.settings.presentation.state

import com.example.testapp.ui.features.settings.data.MarketingOption
import com.example.testapp.ui.features.settings.data.Theme

data class SettingsState(
    val notificationsEnabled:Boolean = false,
    val hintsEnabled:Boolean =  false,
    val marketingOption: MarketingOption
    = MarketingOption.ALLOWED,
    val themeOption: Theme = Theme.SYSTEM
)

