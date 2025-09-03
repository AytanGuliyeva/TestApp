package com.example.testapp.ui.features.emailBox.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.testapp.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmailItemBackground(
    modifier: Modifier = Modifier,
    dismissState: DismissState,
    back: Color
) {
    val iconColor by animateColorAsState(
        targetValue = when (
            dismissState.targetValue
        ) {
            DismissValue.DismissedToEnd ->
                MaterialTheme.colors.onError

            else -> MaterialTheme.colors.onSurface
        },
        animationSpec = tween()
    )

    val scale by animateFloatAsState(
        targetValue = if (dismissState.targetValue == DismissValue.DismissedToEnd) {
            1f
        } else 0.75f
    )

    Box(
        modifier = modifier
            .background(back)
            .padding(horizontal = 20.dp)
    ) {
        if (dismissState.currentValue == DismissValue.Default) {
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .scale(scale),
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(id = R.string.cd_delete_email),
                tint = iconColor
            )
        }
    }
}