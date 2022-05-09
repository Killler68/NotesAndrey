package com.example.notesandrey.minigames

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.R
import com.example.notesandrey.databinding.FragmentGamesCounterBinding


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
                Thread.sleep(1000)
                kotlin.run {
                    if (counter > 5) Thread.sleep(3000)
                    binding.text.text = counter.toString()
                    counter++
                }
            }
        }.start()
    }
}