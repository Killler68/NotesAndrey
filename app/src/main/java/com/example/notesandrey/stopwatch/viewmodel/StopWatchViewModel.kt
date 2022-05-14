package com.example.notesandrey.stopwatch.viewmodel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val HOURS_IN_SECOND = 3600
private const val MINUTES_IN_SECOND = 60
private const val SECOND_IN_MILLIS = 1000
private const val TIME_FORMAT = "%02d:%02d:%02d"
private const val NUMBER_START = 0

class StopWatchMainViewModel() : ViewModel() {

    private val _clock: MutableLiveData<String> = MutableLiveData()
    val clock: LiveData<String> get() = _clock

    var second = NUMBER_START
    var isRunning: Boolean = false
    private val handler = Handler()
    private val runnable = Runnable { runTimer() }

    fun runTimer() {
        handler.post {
            val hours = second / HOURS_IN_SECOND
            val minutes = (second / MINUTES_IN_SECOND) % MINUTES_IN_SECOND
            val secs = second % MINUTES_IN_SECOND
            val time = String.format(
                TIME_FORMAT,
                hours, minutes, secs
            )
            _clock.postValue(time)
            if (isRunning) {
                second++
            }
            handler.postDelayed(runnable, SECOND_IN_MILLIS.toLong())
        }
    }

}