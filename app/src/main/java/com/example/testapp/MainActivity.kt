package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.testapp.ui.features.emailBox.Inbox
import com.example.testapp.ui.features.home.presentation.screen.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContent {
            //Settings()
            //Authentication()
            //Home()
            Inbox()
            }

    }
}
