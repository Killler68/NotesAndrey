package com.example.notesandrey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

private const val MESSAGE_SEND = "Сообщение отправлено"
private const val UN_MESSAGE_SEND = "Сообщение не отправлено"

class ReceiveMessage : Fragment() {

    private val textViewMessage: TextView by lazy {
        requireActivity().findViewById(R.id.text_receive_view)
    }

    private val textEditMessage: EditText by lazy {
        requireActivity().findViewById(R.id.create_message)
    }


    private fun onSendMessage(): String {
        return if (textEditMessage.text.count() > 5) {
            MESSAGE_SEND
        } else {
            UN_MESSAGE_SEND
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sendMessage = onSendMessage()
        textViewMessage.text = sendMessage

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receive_message, container, false)
    }

}