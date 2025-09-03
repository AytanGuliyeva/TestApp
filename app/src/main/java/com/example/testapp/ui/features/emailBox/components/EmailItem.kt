package com.example.testapp.ui.features.emailBox.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.ui.features.emailBox.data.Email

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmailItem(
    modifier: Modifier = Modifier,
    email: Email,
    dismissState: DismissState
) {
    val cardElevation by animateDpAsState(
        if (dismissState.dismissDirection != null) {
            4.dp
        } else 0.dp
    )
    val dividerVisibilityAnimation by animateFloatAsState(
        targetValue = if (
            dismissState.targetValue == DismissValue.Default
        ) {
            1f
        } else
            0f,
        animationSpec = tween(delayMillis = 300)
    )
    Card(
        modifier = modifier.padding(16.dp),
        elevation = cardElevation
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = email.title,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = email.description,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Divider(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .alpha(dividerVisibilityAnimation)
            )
        }
    }
}