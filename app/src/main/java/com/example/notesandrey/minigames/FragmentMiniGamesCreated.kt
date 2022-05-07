package com.example.notesandrey.minigames

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.notesandrey.MyDialogFragment
import com.example.notesandrey.R
import com.example.notesandrey.common.fragment.navigateToFragment
import com.example.notesandrey.databinding.FragmentMiniGamesCreatedBinding


class FragmentMiniGamesCreated : Fragment() {

    private var _binding: FragmentMiniGamesCreatedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mini_games_created, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMiniGamesCreatedBinding.bind(view)

        binding.button1.setOnClickListener {
            navigateToFragment(FragmentGamesCounter())
        }
        binding.button3.setOnClickListener {
            showInfo(text = "no", binding.button3)
        }
        binding.button2.setOnClickListener {
            showInfo(binding.textView.text.toString(), binding.button2)
        }
//        dialogFragment.setOnClickListener {
//            val builder = DialogFragment()
//            val manager = parentFragmentManager
//            builder.show(manager, "MyDialog")
//        }
        binding.button4.setOnClickListener {
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
