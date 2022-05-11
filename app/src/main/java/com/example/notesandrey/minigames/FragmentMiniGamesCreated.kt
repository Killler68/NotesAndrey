package com.example.notesandrey.minigames

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.notesandrey.FragmentMiniSound
import com.example.notesandrey.R
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

        binding.apply {
            button1.setOnClickListener {
                fragmentNavigate(FragmentGamesCounter())
            }
            button3.setOnClickListener {
                showInfo(text = "no", binding.button3)
            }
            button2.setOnClickListener {
                showInfo(binding.textView.text.toString(), binding.button2)
            }
            btnCat.setOnClickListener {
                createSimpleMultiChoiceDialog()
            }
            btnSound.setOnClickListener {
                fragmentNavigate(FragmentMiniSound())
                showInfo(text = "Песня Судно", binding.btnSound)

            }
        }
    }
    private fun fragmentNavigate(fragment: Fragment) {
        this.parentFragmentManager.beginTransaction()
            .replace(R.id.mini_games_constraint, fragment)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }

    private fun showInfo(text: String, btnOn: Button) {

        btnOn.text = "Уже нажали"
        btnOn.setBackgroundColor(Color.RED)
        Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
    }

    private fun createSimpleMultiChoiceDialog() {
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Какой то текст")
            ?.setMultiChoiceItems(R.array.cats, null) { dialog, wich, choise ->
                Log.d("MyLog", "My choise is : $wich Is $choise ")
            }
            ?.setNeutralButton("info", DialogInterface.OnClickListener { dialogInterface, i -> })
            ?.setNegativeButton("No") { dialogInterface, i -> }
            ?.setPositiveButton("Yes") { dialog, i ->
                if (    i == 2  ) {
                    Toast.makeText(activity, "Лучший выбор ", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "ты лох ", Toast.LENGTH_SHORT).show()
                }
            }
        builder?.show()
    }



}
