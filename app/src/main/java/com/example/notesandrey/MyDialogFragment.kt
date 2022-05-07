package com.example.notesandrey

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Важное сообщение")
                .setMessage("Покормите кота")
                .setIcon(R.drawable.cat)
                .setPositiveButton("ОК") { dialog, id ->
                    dialog.cancel()
                }
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }
}