package com.example.notesandrey.message

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.notesandrey.R
import com.example.notesandrey.common.fragment.navigateToFragment

private const val EDIT_SEND_MESSAGE1 = "Сообщение отправлено"
private const val EDIT_SEND_MESSAGE2 = "Сообщение не отправлено"
const val INTENT_TYPE = "text/plain"
private const val NUMBER_LENGTH = 5


class CreateMessage : Fragment() {

    private val sendButton: Button by lazy {
        requireActivity().findViewById(R.id.send_message)
    }
    private val editSendMessage: EditText by lazy {
        requireActivity().findViewById(R.id.message)
    }

    private fun onSendMessage(): String {
        return if (editSendMessage.text.count() > NUMBER_LENGTH) {
            EDIT_SEND_MESSAGE1
        } else {
            EDIT_SEND_MESSAGE2
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sendButton.setOnClickListener {
            val fragmentReceive = ReceiveMessage()
            val bundle = Bundle()
            val sendMessage = onSendMessage()
            bundle.putString(BUNDLE_ARGUMENTS, sendMessage)
            fragmentReceive.arguments = bundle
            navigateToFragment(fragmentReceive)

            val intentEditText = editSendMessage.text
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = (INTENT_TYPE)
            intent.putExtra(Intent.EXTRA_TEXT, intentEditText.toString())
            val chooserTitle = getString(R.string.chooser)
            val chooserIntent = Intent.createChooser(intent, chooserTitle)
            requireActivity().startActivity(chooserIntent)
        }
    }
}