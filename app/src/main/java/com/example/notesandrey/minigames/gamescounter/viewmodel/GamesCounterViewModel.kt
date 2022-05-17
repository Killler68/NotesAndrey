package com.example.notesandrey.minigames.gamescounter.viewmodel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


private const val SPEED_THREAD = 1000
private const val SPEED_COUNTER = 10
private const val CONDITION_NUMBER_1 = 5
private const val CONDITION_NUMBER_2 = 8
private const val COUNTER_START_VALUE = 0

class GamesCounterViewModel : ViewModel() {

    private val _gamesCounter: MutableLiveData<String> = MutableLiveData()
    val gamesCounter: LiveData<String> get() = _gamesCounter

    private var counter = COUNTER_START_VALUE
    private var start = false

    fun counterOn() {
        Thread {
            start = true
            while (start) {
                Thread.sleep(SPEED_THREAD.toLong())
                if (counter > CONDITION_NUMBER_1) _gamesCounter.postValue(
                    Thread.sleep(SPEED_COUNTER.toLong()).toString()
                )
                if (counter == CONDITION_NUMBER_2) _gamesCounter.postValue(Color.RED.toString())
                _gamesCounter.postValue(counter.toString())
                counter++
            }
        }.start()
    }
}