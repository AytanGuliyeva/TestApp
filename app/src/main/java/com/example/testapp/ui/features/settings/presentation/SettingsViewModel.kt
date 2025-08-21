package com.example.testapp.ui.features.settings.presentation

import androidx.lifecycle.ViewModel
import com.example.testapp.ui.features.settings.data.MarketingOption
import com.example.testapp.ui.features.settings.data.Theme
import com.example.testapp.ui.features.settings.presentation.state.SettingsState
import kotlinx.coroutines.flow.MutableStateFlow

class SettingsViewModel:ViewModel(){
    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationSettings(checked:Boolean){
     uiState.value = uiState.value.copy(notificationsEnabled = !uiState.value.notificationsEnabled)
    }

    fun toggleHintSettings(checked: Boolean) {
        uiState.value = uiState.value.copy(hintsEnabled = !uiState.value.hintsEnabled)
    }

    fun setMarketingSettings(option: MarketingOption){
        uiState.value = uiState.value.copy(
            marketingOption = option
        )
    }

    fun setTheme(theme: Theme){
        uiState.value=uiState.value.copy(themeOption =  theme)
    }

}