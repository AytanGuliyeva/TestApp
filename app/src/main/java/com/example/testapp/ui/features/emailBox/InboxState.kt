package com.example.testapp.ui.features.emailBox


data class InboxState(
    val status: InboxStatus = InboxStatus.LOADING,
    val content: List<Email>? = null
)