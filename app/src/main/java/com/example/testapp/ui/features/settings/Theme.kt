package com.example.testapp.ui.features.settings

import androidx.annotation.StringRes
import com.example.testapp.R

enum class Theme (@StringRes val label:Int){
    LIGHT(R.string.theme_light),
    DARK(R.string.theme_dark),
    SYSTEM(R.string.theme_system)
}