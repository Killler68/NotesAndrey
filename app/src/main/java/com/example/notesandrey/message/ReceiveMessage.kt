package com.example.notesandrey.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.notesandrey.R

const val BUNDLE_ARGUMENTS = "key"

class ReceiveMessage : Fragment() {

    private val textViewMessage: TextView by lazy {
        requireActivity().findViewById(R.id.text_receive_view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receive_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultSend = arguments?.getString(BUNDLE_ARGUMENTS)
        textViewMessage.text = resultSend.toString()
    }
}