package com.example.notesandrey.counter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesandrey.counter.repository.CounterRepository


private const val NUMBER_START = 0

class CounterViewModel(private val repository: CounterRepository) : ViewModel() {

    private val _counter1: MutableLiveData<String> = MutableLiveData()
    val counter1: LiveData<String> get() = _counter1

    private val _counter2: MutableLiveData<String> = MutableLiveData()
    val counter2: LiveData<String> get() = _counter2

    private val _outputText: MutableLiveData<String> = MutableLiveData()
    val outputText: LiveData<String> get() = _outputText

    private var counter = NUMBER_START
    var isRunning: Boolean = false

    fun increasing1() {
        val counterText = repository.getText()
        _counter1.postValue(counterText + counter.toString())
//        if (isRunning)
            counter++
    }

    fun increasing2() {
        val counterText = repository.getText2()
        _counter2.postValue(counterText + counter.toString())
//        if (isRunning)
            counter++
    }

    fun onShowText(text: String) {
        _outputText.postValue(text)
    }
}