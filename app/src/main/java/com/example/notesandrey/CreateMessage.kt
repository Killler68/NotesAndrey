package com.example.notesandrey

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.notesandrey.extensions.navigateToFragmentWithOutBackStack

val intent = Intent(Intent.ACTION_SEND)

class CreateMessage : Fragment() {

    private val createButton: Button by lazy {
        requireActivity().findViewById(R.id.create_send)
    }
    private val editSendMessage: EditText by lazy {
        requireActivity().findViewById(R.id.create_message)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createButton.setOnClickListener {
            navigateToFragmentWithOutBackStack(ReceiveMessage())
            val intentEditText = editSendMessage.text
            intent.type = ("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, intentEditText.toString())
            requireActivity().startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_message, container, false)
    }
}