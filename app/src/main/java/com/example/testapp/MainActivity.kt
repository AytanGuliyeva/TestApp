package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.testapp.ui.features.authenticationForm.screen.Authentication
import com.example.testapp.ui.features.home.Home
import com.example.testapp.ui.features.settings.presentation.screen.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContent {
          //         Settings()
       //  Authentication()
            Home()
            }

    }
}
