package com.example.notesandrey.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesandrey.mainscreen.repository.MainRepositoryImpl

class MainViewModelFactory : ViewModelProvider.Factory {

    private val repository = MainRepositoryImpl()
    private val mainViewModel = MainViewModel(repository)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        mainViewModel as T
}