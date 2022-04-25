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

private const val EDIT_SEND_MESSAGE1 = "Сообщение отправлено"
private const val EDIT_SEND_MESSAGE2 = "Сообщение не отправлено"
const val INTENT_TYPE = "text/plain"

class CreateMessage : Fragment() {

    private val sendButton: Button by lazy {
        requireActivity().findViewById(R.id.send_message)
    }
    private val editSendMessage: EditText by lazy {
        requireActivity().findViewById(R.id.message)
    }

    private fun onSendMessage(): String {
        return if (editSendMessage.text.count() > 5) {
            EDIT_SEND_MESSAGE1
        } else {
            EDIT_SEND_MESSAGE2
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sendButton.setOnClickListener {
            val fragmentReceive = ReceiveMessage()
            val bundle = Bundle()
            val sendMessage = onSendMessage()
            bundle.putString(BUNDLE_ARGUMENTS, sendMessage)
            fragmentReceive.arguments = bundle
            navigateToFragmentWithOutBackStack(fragmentReceive)

            val intentEditText = editSendMessage.text
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = (INTENT_TYPE)
            intent.putExtra(Intent.EXTRA_TEXT, intentEditText.toString())
            val chooserTitle = getString(R.string.chooser)
            val chooserIntent = Intent.createChooser(intent, chooserTitle)
            requireActivity().startActivity(chooserIntent)
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