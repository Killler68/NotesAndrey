package com.example.notesandrey.counter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesandrey.counter.repository.CounterRepository

class CounterViewModelFactory: ViewModelProvider.Factory {

    private val repository = CounterRepository()
    private val counterViewModel = CounterViewModel(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        counterViewModel as T
}