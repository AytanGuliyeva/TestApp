package com.example.testapp.ui.features.authenticationForm.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.testapp.ui.features.authenticationForm.data.PasswordRequirements


@Composable
fun PasswordRequirement(
    modifier: Modifier = Modifier,
    satisfiedRequirements: List<PasswordRequirements>
){
    Column(modifier = modifier) {
        PasswordRequirements.entries.forEach {
            requirements -> Requirement(
                message = stringResource(id = requirements.label),
                satisfied = satisfiedRequirements.contains(requirements)
            )
        }
    }
}