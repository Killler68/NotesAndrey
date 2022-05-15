package com.example.notesandrey.calculator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CalculatorViewModelFactory : ViewModelProvider.Factory {

    private val calculatorViewModel = CalculatorViewModel()

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        calculatorViewModel as T
}