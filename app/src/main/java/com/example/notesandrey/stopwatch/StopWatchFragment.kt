package com.example.notesandrey.stopwatch

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.databinding.FragmentStopwatchBinding

private const val START_TIME = 0
private const val HOURS_IN_SECOND = 3600
private const val MINUTES_IN_SECOND = 60
private const val SECOND_IN_MILLIS = 1000
private const val TIME_FORMAT = "%02d:%02d:%02d"
private const val SECOND = "second"
private const val RUNNING = "running"

class StopWatchFragment : Fragment() {

    private var _binding: FragmentStopwatchBinding? = null
    private val binding get() = _binding!!

    private var second = 0
    private var isRunning: Boolean = false
    private val handler = Handler()
    private val runnable = Runnable { runTimer() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStopwatchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            second = savedInstanceState.getInt(SECOND)
            isRunning = savedInstanceState.getBoolean(RUNNING)
        }
        runTimer()

        binding.apply {
            startButton.setOnClickListener {
                startButton.isEnabled = false
                isRunning = true
            }
            stopButton.setOnClickListener {
                startButton.isEnabled = true
                isRunning = false
            }
            resetButton.setOnClickListener {
                startButton.isEnabled = true
                isRunning = false
                second = START_TIME
            }
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
            binding.timeView.text = time
            if (isRunning) {
                second++
            }
            handler.postDelayed(runnable, SECOND_IN_MILLIS.toLong())
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SECOND, second)
        outState.putBoolean(RUNNING, isRunning)
    }
}