package com.example.testapp.ui.features.settings

data class SettingsState(
    val notificationsEnabled:Boolean = false,
    val hintsEnabled:Boolean =  false,
    val marketingOption: MarketingOption
    = MarketingOption.ALLOWED,
   // val marketingSettingsOption:Int = 0,
    val themeOption: Theme = Theme.SYSTEM
)

