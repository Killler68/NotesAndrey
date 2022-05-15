package com.example.notesandrey.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notesandrey.counter.viewmodel.CounterViewModel
import com.example.notesandrey.counter.viewmodel.CounterViewModelFactory
import com.example.notesandrey.databinding.FragmentCounterBinding
import kotlinx.coroutines.*


class FragmentCounter : Fragment() {

    private var coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default)

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CounterViewModel by viewModels { CounterViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            counter1.observe(viewLifecycleOwner) {
                binding.counterText1.text = it
            }
            counter2.observe(viewLifecycleOwner) {
                binding.counterText2.text = it
            }
            outputText.observe(viewLifecycleOwner) {
                binding.outputText.text = it
            }
            increasing1()
            increasing2()
        }

        binding.button.setOnClickListener {
            viewModel.onShowText(binding.inputText.text.toString())
        }
        binding.btnCounterStart.setOnClickListener {
            binding.btnCounterStart.isEnabled = false

            coroutineScope = CoroutineScope(Dispatchers.Default)
            coroutineScope.launch {
                loadDataEverySecond()
            }
        }
        binding.btnCounterStop.setOnClickListener {
            binding.btnCounterStart.isEnabled = true
            coroutineScope.cancel()
        }


    }

    private suspend fun loadDataEverySecond() {
        coroutineScope.launch {
            viewModel.increasing1()
            viewModel.increasing2()
            delay(1000)
            loadDataEverySecond()
        }
    }
}