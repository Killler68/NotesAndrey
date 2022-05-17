package com.example.notesandrey.minigames.gamescounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GamesCounterViewModelFactory : ViewModelProvider.Factory {

    private val gamesCounterViewModel = GamesCounterViewModel()

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        gamesCounterViewModel as T
}