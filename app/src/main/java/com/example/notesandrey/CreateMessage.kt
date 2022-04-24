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

private const val MESSAGE_SEND = "Сообщение отправлено"
private const val UN_MESSAGE_SEND = "Сообщение не отправлено"
const val bundleArguments = "MyArg"
const val intentType = "text/plain"

class CreateMessage : Fragment() {

    private val createButton: Button by lazy {
        requireActivity().findViewById(R.id.create_send)
    }
    private val editSendMessage: EditText by lazy {
        requireActivity().findViewById(R.id.create_message)
    }

    private fun onSendMessage(): String {
        return if (editSendMessage.text.count() > 5) {
            MESSAGE_SEND
        } else {
            UN_MESSAGE_SEND
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createButton.setOnClickListener {
            val fragmentReceive = ReceiveMessage()
            val bundle = Bundle()
//            val nameMessage = onSendMessage()
            bundle.putString(bundleArguments, onSendMessage())
            fragmentReceive.arguments = bundle
            navigateToFragmentWithOutBackStack(fragmentReceive)

            val intentEditText = editSendMessage.text
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = (intentType)
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