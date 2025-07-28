package com.example.testapp.ui.features

data class SettingsState(
    val notificationsEnabled:Boolean = false,
    val hintsEnabled:Boolean =  false,
    val marketingOption: MarketingOption = MarketingOption.ALLOWED
)
