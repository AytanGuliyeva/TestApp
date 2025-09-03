package com.example.testapp.ui.features.emailBox.state

import com.example.testapp.ui.features.emailBox.data.Email
import com.example.testapp.ui.features.emailBox.data.InboxStatus


data class InboxState(
    val status: InboxStatus = InboxStatus.LOADING,
    val content: List<Email>? = null
)