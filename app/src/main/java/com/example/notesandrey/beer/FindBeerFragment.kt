package com.example.notesandrey.beer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.databinding.FragmentFindBeerBinding


class FindBeerFragment : Fragment() {

    private var _binding: FragmentFindBeerBinding? = null
    private val binding get() = _binding!!

    private fun beerExpert(color: String): List<String> {

        val list = when (color) {
            "amber" -> listOf("Jack Amber", "Red Mouse")
            "light" -> listOf("Жатецкий гусь", "Milky way")
            "dark" -> listOf("387", "Козел")
            "brown" -> listOf("Joy", "Hot Boy")
            else -> emptyList()
        }
        return list
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFindBeerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beerExpert("amber")
        binding.findBeer.setOnClickListener {

            val beerType = binding.spinnerBeerColor.selectedItem.toString()
            binding.brands.text = beerType
            var str = ""

            for (brand in beerExpert(beerType)) {
                str += brand + "\n"
            }
            binding.brands.text = str
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}