package com.example.notesandrey.stopwatch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StopWatchViewModelFactory : ViewModelProvider.Factory {

    private val stopWatchViewModel = StopWatchMainViewModel()

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        stopWatchViewModel as T
}