package com.example.notesandrey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView


class FindBeerFragment : Fragment() {

    private val brand: TextView by lazy {
        requireActivity().findViewById(R.id.brands)
    }
    private val spinner: Spinner by lazy {
        requireActivity().findViewById(R.id.color)
    }

    private val button: Button by lazy {
        requireActivity().findViewById(R.id.find_beer)
    }

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        beerExpert("amber")

        button.setOnClickListener {

            val beerType = spinner.selectedItem.toString()
            brand.text = beerType
            var str = ""

            for (brand in beerExpert(beerType)) {
                str += brand + "\n"
            }
            brand.text = str
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_beer, container, false)
    }
}