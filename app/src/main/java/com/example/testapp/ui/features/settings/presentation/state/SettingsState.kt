package com.example.testapp.ui.features.settings.presentation.state

import com.example.testapp.ui.features.settings.domain.model.MarketingOption
import com.example.testapp.ui.features.settings.domain.model.Theme

data class SettingsState(
    val notificationsEnabled:Boolean = false,
    val hintsEnabled:Boolean =  false,
    val marketingOption: MarketingOption
    = MarketingOption.ALLOWED,
    val themeOption: Theme = Theme.SYSTEM
)

