package com.example.notesandrey.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.databinding.FragmentReceiveMessageBinding

const val BUNDLE_ARGUMENTS = "key"

class ReceiveMessage : Fragment() {

    private var _binding: FragmentReceiveMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentReceiveMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultSend = arguments?.getString(BUNDLE_ARGUMENTS)
        binding.textReceiveView.text = resultSend.toString()
    }
}