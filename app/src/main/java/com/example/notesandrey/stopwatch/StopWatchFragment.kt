package com.example.notesandrey.stopwatch

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.notesandrey.R

private const val START_TIME = 0
private const val HOURS_IN_SECOND = 3600
private const val MINUTES_IN_SECOND = 60
private const val SECOND_IN_MILLIS = 1000
private const val TIME_FORMAT = "%02d:%02d:%02d"

class StopWatchFragment : Fragment() {

    private val timeView: TextView by lazy {
        requireActivity().findViewById(R.id.time_view)
    }
    private val startButton: Button by lazy {
        requireActivity().findViewById(R.id.start_button)
    }
    private val stopButton: Button by lazy {
        requireActivity().findViewById(R.id.stop_button)
    }
    private val resetButton: Button by lazy {
        requireActivity().findViewById(R.id.reset_button)
    }

    private var second = 0
    private var isRunning: Boolean = false
    private val handler = Handler()
    private val runnable = Runnable { runTimer() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stopwatch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            second = savedInstanceState.getInt("second")
            isRunning = savedInstanceState.getBoolean("running")
        }
        runTimer()

        startButton.setOnClickListener {
            startButton.isEnabled = false
            isRunning = true
        }
        stopButton.setOnClickListener {
            startButton.isEnabled = true
            isRunning = false
        }
        resetButton.setOnClickListener {
            isRunning = false
            second = START_TIME
        }
    }

    private fun runTimer() {
        handler.post {
            val hours = second / HOURS_IN_SECOND
            val minutes = (second / MINUTES_IN_SECOND) % MINUTES_IN_SECOND
            val secs = second % MINUTES_IN_SECOND
            val time = String.format(
                TIME_FORMAT,
                hours, minutes, secs
            )
            timeView.text = time
            if (isRunning) {
                second++
            }
            handler.postDelayed(runnable, SECOND_IN_MILLIS.toLong())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("second", second)
        outState.putBoolean("running", isRunning)
    }
}