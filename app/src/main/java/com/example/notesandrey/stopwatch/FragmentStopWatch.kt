package com.example.notesandrey.stopwatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notesandrey.databinding.FragmentStopWatchBinding
import com.example.notesandrey.stopwatch.viewmodel.StopWatchViewModelFactory
import com.example.notesandrey.stopwatch.viewmodel.StopWatchMainViewModel


private const val START_TIME = 0

class FragmentStopWatch : Fragment() {

    private var _binding: FragmentStopWatchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StopWatchMainViewModel by viewModels { StopWatchViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStopWatchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            clock.observe(viewLifecycleOwner) {
                binding.timeViewMvvm.text = it
            }
            runTimer()
        }
        binding.apply {
            startButtonMvvm.setOnClickListener {
                startButtonMvvm.isEnabled = false
                viewModel.isRunning = true
            }
            stopButtonMvvm.setOnClickListener {
                startButtonMvvm.isEnabled = true
                viewModel.isRunning = false
            }
            resetButtonMvvm.setOnClickListener {
                startButtonMvvm.isEnabled = true
                viewModel.isRunning = false
                viewModel.second = START_TIME
            }
        }
    }
}