package com.example.notesandrey.message.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MessageViewModelFactory : ViewModelProvider.Factory {

   private val messageViewModel = MessageViewModel()

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        messageViewModel as T
}