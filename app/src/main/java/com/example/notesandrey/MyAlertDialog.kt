package com.example.notesandrey

import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Log
import androidx.fragment.app.DialogFragment

class MyAlertDialog : DialogFragment() {
     fun createSimpleMultiChoiceDialog() {
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Какой то текст")
            ?.setMultiChoiceItems(R.array.cats, null) { dialog, wich, choise ->
                Log.d("MyLog", "My choiсe is : $wich Is $choise ")
            }
            ?.setNeutralButton("info", DialogInterface.OnClickListener { dialogInterface, i -> })
            ?.setNegativeButton("No") { dialogInterface, i -> }
            ?.setPositiveButton("Yes") { dialog, i ->
//                if (      ) {
//                    Toast.makeText(activity, "Лучший выбор ", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(activity, "ты лох ", Toast.LENGTH_SHORT).show()
//                }
            }
        builder?.show()
    }
}