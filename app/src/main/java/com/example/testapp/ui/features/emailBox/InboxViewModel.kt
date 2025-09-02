package com.example.testapp.ui.features.emailBox

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class InboxViewModel : ViewModel() {
    val uiState = MutableStateFlow(InboxState())

    fun loadContent() {
        uiState.value = uiState.value.copy(
            status = InboxStatus.LOADING
        )
        uiState.value = uiState.value.copy(
            status = InboxStatus.SUCCESS,
            content = EmailFactory.makeEmailList()
        )
    }

    fun handleEvent(contentEvent: InboxEvent){
        when(contentEvent){
            is InboxEvent.RefreshContent -> loadContent()
            is InboxEvent.DeleteEmail -> deleteEmail(contentEvent.id)

        }
    }

    private fun deleteEmail(id:String){
        uiState.update { state ->
            state.copy(content = state.content?.filterNot { it.id == id })
        }
    }
}