package com.example.notesandrey.minigames

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.R
import com.example.notesandrey.databinding.FragmentGamesCounterBinding

private const val SPEED_THREAD = 1000
private const val CONDITION_NUMBER_1 = 5
private const val CONDITION_NUMBER_2 = 8

class FragmentGamesCounter : Fragment() {

    private var _binding: FragmentGamesCounterBinding? = null
    private val binding get() = _binding!!

    private var counter = 0
    private var start = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGamesCounterBinding.bind(view)
        Thread {
            start = true
            while (start) {
                Thread.sleep(SPEED_THREAD.toLong())
                kotlin.run {
                    if (counter > CONDITION_NUMBER_1) Thread.sleep(SPEED_THREAD.toLong())
                    if (counter == CONDITION_NUMBER_2) binding.text.setTextColor(Color.RED)
                    binding.text.text = counter.toString()
                    counter++
                }
            }
        }.start()
    }
}