package com.example.testapp.ui.features.authenticationForm.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.testapp.ui.features.authenticationForm.components.AuthenticationErrorDialog
import com.example.testapp.ui.features.authenticationForm.components.AuthenticationForm
import com.example.testapp.ui.features.authenticationForm.state.AuthenticationEvent
import com.example.testapp.ui.features.authenticationForm.state.AuthenticationState

@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit
) {

    Box(
        modifier = modifier.padding(),
        contentAlignment = Alignment.Center
    ) {
        if (authenticationState.isLoading) {
            CircularProgressIndicator()
        } else {
            AuthenticationForm(
                modifier = Modifier.fillMaxSize(),
                authenticationMode = authenticationState.authenticationMode,
                email = authenticationState.email.toString(),
                password =
                    authenticationState.password.toString(),
                completedPasswordRequirements = authenticationState.passwordRequirements,
                enableAuthentication = authenticationState.isFormValid(),
                onEmailChanged = { email ->
                    handleEvent(
                        AuthenticationEvent.EmailChanged(email)
                    )
                },
                onPasswordChanged = { handleEvent(AuthenticationEvent.PasswordChanged(it)) },
                onAuthenticate = {
                    handleEvent(AuthenticationEvent.Authenticate)
                },
                onToggleMode = {
                    handleEvent(
                        AuthenticationEvent.ToggleAuthenticationMode
                    )
                }
            )

            authenticationState.error?.let { error ->
                AuthenticationErrorDialog(
                    error = error,
                    dismissError = { handleEvent(AuthenticationEvent.ErrorDismissed) })
            }
        }
    }

}