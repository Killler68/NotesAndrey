package com.example.notesandrey.beer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BeerViewModelFactory : ViewModelProvider.Factory {

    private val beerViewModel = BeerViewModel()

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        beerViewModel as T

}