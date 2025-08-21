package com.example.testapp.ui.features.authenticationForm.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp
import com.example.testapp.ui.features.authenticationForm.data.AuthenticationMode
import com.example.testapp.ui.features.authenticationForm.data.PasswordRequirements

@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    email: String,
    password: String,
    completedPasswordRequirements: List<PasswordRequirements>,
    enableAuthentication: Boolean,
    onEmailChanged: (email: String) -> Unit,
    onPasswordChanged: (email: String) -> Unit,
    onAuthenticate: () -> Unit,
    onToggleMode: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        AuthenticationTitle(
            modifier = modifier.fillMaxWidth(),
            authenticationMode = authenticationMode
        )
        Spacer(modifier = Modifier.height(10.dp))
        FocusRequester()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 30.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmailInput(
                    modifier = Modifier.fillMaxWidth(),
                    email = email,
                    onEmailChanged = onEmailChanged,
                    onNextClicked = { }
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordInput(
                    modifier = Modifier.fillMaxWidth(),
                    password = password,
                    onPasswordChanged = onPasswordChanged,
                    onDoneClicked = onAuthenticate
                )
                Spacer(modifier = Modifier.height(12.dp))
                AnimatedVisibility(visible = authenticationMode == AuthenticationMode.SIGN_UP) {
                    PasswordRequirement(satisfiedRequirements=completedPasswordRequirements)
                }
                Spacer(modifier = Modifier.height(12.dp))
                AuthenticationButton(
                    enableAuthentication = enableAuthentication,
                    authenticationMode = authenticationMode,
                    onAuthenticate = onAuthenticate
                )
                Spacer(modifier = Modifier.weight(1f))
                ToggleAuthenticationMode(
                    modifier = Modifier.fillMaxWidth(),
                    authenticationMode = authenticationMode,
                    toggleAuthentication = { onToggleMode() })
                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }
}

