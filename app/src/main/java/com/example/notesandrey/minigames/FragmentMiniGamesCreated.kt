package com.example.notesandrey.minigames

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.notesandrey.MyDialogFragment
import com.example.notesandrey.R
import com.example.notesandrey.common.fragment.navigateToFragment


class FragmentMiniGamesCreated : Fragment() {


    private val btn1: Button by lazy {
        requireActivity().findViewById(R.id.button1)
    }
    private val btn2: Button by lazy {
        requireActivity().findViewById(R.id.button2)
    }
    private val btn3: Button by lazy {
        requireActivity().findViewById(R.id.button3)
    }
    private val textName: TextView by lazy {
        requireActivity().findViewById(R.id.textView)
    }
    private val dialogFragment: Button by lazy {
        requireActivity().findViewById(R.id.button4)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mini_games_created, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1.setOnClickListener {
            navigateToFragment(FragmentGamesCounter())
        }
        btn3.setOnClickListener {
            showInfo(text = "no", btn3)
        }
        btn2.setOnClickListener {
            showInfo(textName.text.toString(), btn2)
        }
//        dialogFragment.setOnClickListener {
//            val builder = DialogFragment()
//            val manager = parentFragmentManager
//            builder.show(manager, "MyDialog")
//        }
        dialogFragment.setOnClickListener {
            navigateToFragment(MyDialogFragment())
        }
    }



    private fun showInfo(text: String, btnOn: Button) {

        btnOn.text = "Уже нажали"
        btnOn.setBackgroundColor(Color.RED)
        Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
    }
//  private  fun createSimpleDialog() {
//        val builder = DialogFragment()
//        builder
//    }
}
