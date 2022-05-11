package com.example.notesandrey.minigames

import android.app.AlertDialog
import android.app.Dialog
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

private const val NAME_BUTTON_CLICK = "Уже нажали"
private const val NAME_BUTTON_CLICK_ANSWER = "NO"
private const val NAME_SOUND = "Песня Судно"
private const val TITLE = "Какой котик милее?"
private const val NEUTRAL_BUTTON = "INFO"
private const val POSITIVE_BUTTON = "YES"
private const val NEGATIVE_BUTTON = "No"


class FragmentMiniGamesCreated : Fragment() {

    private var _binding: FragmentMiniGamesCreatedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMiniGamesCreatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            button1.setOnClickListener {
                fragmentNavigate(FragmentGamesCounter())
            }
            button3.setOnClickListener {
                showInfo(text = NAME_BUTTON_CLICK_ANSWER, binding.button3)
            }
            button2.setOnClickListener {
                showInfo(binding.textView.text.toString(), binding.button2)
            }
            btnCat.setOnClickListener {
                createSimpleMultiChoiceDialog()
            }
            btnSound.setOnClickListener {
                fragmentNavigate(FragmentMiniSound())
                showInfo(text = NAME_SOUND, binding.btnSound)
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

        btnOn.text = NAME_BUTTON_CLICK
        btnOn.setBackgroundColor(Color.RED)
        Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
    }

    private fun createSimpleMultiChoiceDialog(): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(TITLE)
                .setMultiChoiceItems(R.array.cats, null) { dialog, wich, choise ->
                    Log.d("MyLog", "My choise is : $wich Is $choise ")
                }
                .setNeutralButton(NEUTRAL_BUTTON) { dialogInterface, i -> }
                .setNegativeButton(NEGATIVE_BUTTON) { dialogInterface, i -> }
                .setPositiveButton(POSITIVE_BUTTON) { dialog, i ->
                }
            builder.show()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
