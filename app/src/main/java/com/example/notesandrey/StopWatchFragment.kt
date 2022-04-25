package com.example.notesandrey

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

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
    private val zero = 0
    private val hoursInSecond = 3600
    private val minutesInSecond = 60
    private val secondInMillis = 1000
    private var isRunning: Boolean = false
    private val handler = Handler()
    private val runnable = Runnable { runTimer() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        runTimer()

        startButton.setOnClickListener() {
            startButton.isEnabled = false
            isRunning = true
        }
        stopButton.setOnClickListener {
            startButton.isEnabled = true
            isRunning = false
        }
        resetButton.setOnClickListener {
            isRunning = false
            second = zero
        }
    }

    private fun runTimer() {
        handler.post {
            val hours = second / hoursInSecond
            val minutes = (second / minutesInSecond) % minutesInSecond
            val secs = second % minutesInSecond
            val time = String.format(
                "%02d:%02d:%02d",
                hours, minutes, secs
            )
            timeView.text = time
            if (isRunning) {
                second++
            }
            handler.postDelayed(runnable, secondInMillis.toLong())
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stopwatch, container, false)
    }

}