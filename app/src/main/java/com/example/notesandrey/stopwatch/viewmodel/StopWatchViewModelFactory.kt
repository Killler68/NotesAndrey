package com.example.notesandrey.stopwatch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StopWatchViewModelFactory : ViewModelProvider.Factory {

    private val mainViewModel = StopWatchMainViewModel()

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        mainViewModel as T


}