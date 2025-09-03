package com.example.testapp.ui.features.emailBox.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.ui.features.emailBox.data.Email
import com.example.testapp.ui.features.emailBox.state.InboxEvent

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmailList(
    modifier: Modifier = Modifier,
    emails: List<Email>,
    inboxEventListener: (InboxEvent) -> Unit
) {
    val deleteEmailLabel = stringResource(id = R.string.cd_delete_email)

    LazyColumn(modifier = modifier) {
        items(items = emails, key = { it.id }) { email ->

            val dismissState = rememberDismissState(
                confirmStateChange = { newValue ->
                    if (newValue == DismissValue.DismissedToEnd) {
                        inboxEventListener(InboxEvent.DeleteEmail(email.id))
                        true
                    } else {
                        true
                    }
                }
            )

            val targetHeight =
                if (dismissState.currentValue == DismissValue.DismissedToEnd) 0.dp else 120.dp
            val itemHeight by animateDpAsState(
                targetValue = targetHeight,
                animationSpec = tween(durationMillis = 300)
            )
            SwipeToDismiss(
                modifier = Modifier.semantics {
                    customActions = listOf(
                        CustomAccessibilityAction(deleteEmailLabel) {
                            inboxEventListener(InboxEvent.DeleteEmail(email.id))
                            true
                        }
                    )
                },
                state = dismissState,
                directions = setOf(DismissDirection.StartToEnd),
                dismissThresholds = { FractionalThreshold(0.15f) },
                background = {
                    EmailItemBackground(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(itemHeight),
                        dismissState = dismissState,
                        back = when (dismissState.targetValue) {
                            DismissValue.DismissedToEnd -> MaterialTheme.colors.error
                            else -> MaterialTheme.colors.background
                        }
                    )
                },
                dismissContent = {
                    EmailItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(itemHeight),
                        email = email,
                        dismissState = dismissState
                    )
                }
            )
        }
    }
}
