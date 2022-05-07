package com.example.notesandrey.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.R
import com.example.notesandrey.databinding.FragmentReceiveMessageBinding

const val BUNDLE_ARGUMENTS = "key"

class ReceiveMessage : Fragment() {

    private var _binding: FragmentReceiveMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receive_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReceiveMessageBinding.bind(view)
        val resultSend = arguments?.getString(BUNDLE_ARGUMENTS)
        binding.textReceiveView.text = resultSend.toString()
    }
}