package com.example.notesandrey.soundsplin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SoundSplinViewModelFactory : ViewModelProvider.Factory {

    private val soundSplinViewModel = SoundSplinViewModel()

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        soundSplinViewModel as T
}