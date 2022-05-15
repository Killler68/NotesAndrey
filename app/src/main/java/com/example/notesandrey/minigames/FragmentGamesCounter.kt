package com.example.notesandrey.minigames

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.databinding.FragmentGamesCounterBinding

private const val SPEED_THREAD = 1000
private const val CONDITION_NUMBER_1 = 5
private const val CONDITION_NUMBER_2 = 8
private const val COUNTER_START_VALUE = 0

class FragmentGamesCounter : Fragment() {

    private var _binding: FragmentGamesCounterBinding? = null
    private val binding get() = _binding!!

    private var counter = COUNTER_START_VALUE
    private var start = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGamesCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread {
            start = true
            while (start) {
                Thread.sleep(SPEED_THREAD.toLong())
                kotlin.run {
                    if (counter > CONDITION_NUMBER_1) Thread.sleep(SPEED_THREAD.toLong())
                    if (counter == CONDITION_NUMBER_2) binding.counterText.setTextColor(Color.RED)
                    binding.counterText.text = counter.toString()
                    counter++
                }
            }
        }.start()
    }
}