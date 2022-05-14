package com.example.notesandrey.beer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notesandrey.beer.viewmodel.BeerViewModelFactory
import com.example.notesandrey.beer.viewmodel.MainViewModel
import com.example.notesandrey.databinding.FragmentBeerBinding


class FragmentBeer : Fragment() {

    private var _binding: FragmentBeerBinding? = null
    val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels { BeerViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBeerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            brands.observe(viewLifecycleOwner) {
                binding.brands.text = it
            }
        }
        binding.findBeer.setOnClickListener {
            viewModel.fiendBeerExpert(binding.spinnerBeerColor.selectedItem.toString())
        }
    }
}