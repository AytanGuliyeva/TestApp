package com.example.testapp.ui.features.emailBox.state

sealed class InboxEvent {
    data object RefreshContent: InboxEvent()
    class DeleteEmail(val id: String): InboxEvent()
}