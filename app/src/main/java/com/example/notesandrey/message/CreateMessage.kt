package com.example.notesandrey.message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.R
import com.example.notesandrey.common.fragment.navigateToFragment
import com.example.notesandrey.databinding.FragmentCreateMessageBinding


private const val EDIT_SEND_MESSAGE1 = "Сообщение отправлено"
private const val EDIT_SEND_MESSAGE2 = "Сообщение не отправлено"
private const val INTENT_TYPE = "text/plain"
private const val NUMBER_LENGTH = 5

class CreateMessage : Fragment() {

    private var _binding: FragmentCreateMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCreateMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendMessage.setOnClickListener {
            messageOn()
        }
    }

    private fun messageOn() {
        receiveMessage()
        intentMessage()
    }

    private fun receiveMessage() {
        val fragmentReceive = ReceiveMessage()
        val bundle = Bundle()
        val sendMessage = onSendMessage()
        bundle.putString(BUNDLE_ARGUMENTS, sendMessage)
        fragmentReceive.arguments = bundle
        navigateToFragment(fragmentReceive)
    }

    private fun intentMessage() {
        val intentEditText = binding.message.text
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = (INTENT_TYPE)
        intent.putExtra(Intent.EXTRA_TEXT, intentEditText.toString())
        val chooserTitle = getString(R.string.chooser)
        val chooserIntent = Intent.createChooser(intent, chooserTitle)
        requireActivity().startActivity(chooserIntent)
    }

    private fun onSendMessage(): String {
        return if (binding.message.text.count() > NUMBER_LENGTH) {
            EDIT_SEND_MESSAGE1
        } else {
            EDIT_SEND_MESSAGE2
        }
    }
}