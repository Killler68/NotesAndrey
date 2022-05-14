package com.example.notesandrey.beer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BeerViewModelFactory : ViewModelProvider.Factory {

    private val mainViewModel = MainViewModel()

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        mainViewModel as T

}