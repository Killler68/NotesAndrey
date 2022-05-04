package com.example.notesandrey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class FragmentGamesCounter : Fragment() {

    private var counter = 0
    private var start = false
    private val text: TextView by lazy {
        requireActivity().findViewById(R.id.text)
    }
    private val backgroundLayout: ConstraintLayout by lazy {
        requireActivity().findViewById(R.id.background_layout_fragment_second)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread {
            start = true
            while (start) {
                Thread.sleep(1000)
                kotlin.run {
//                    if (counter == 5) backgroundLayout.setBackgroundColor(Color.RED)
                    text.text = counter.toString()
                    counter++
                }
            }
        }.start()
    }
}