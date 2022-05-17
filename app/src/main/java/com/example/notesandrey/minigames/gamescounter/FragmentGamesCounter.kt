package com.example.notesandrey.minigames.gamescounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notesandrey.databinding.FragmentGamesCounterBinding
import com.example.notesandrey.minigames.gamescounter.viewmodel.GamesCounterViewModel
import com.example.notesandrey.minigames.gamescounter.viewmodel.GamesCounterViewModelFactory


class FragmentGamesCounter : Fragment() {

    private var _binding: FragmentGamesCounterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GamesCounterViewModel by viewModels { GamesCounterViewModelFactory() }

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
        viewModel.gamesCounter.observe(viewLifecycleOwner) {
            binding.counterText.text = it
        }
        viewModel.counterOn()
    }
}