package com.example.notesandrey

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


private const val NUMBER_0 = "0"
private const val NUMBER_1 = "1"
private const val NUMBER_2 = "2"
private const val NUMBER_3 = "3"
private const val NUMBER_4 = "4"
private const val NUMBER_5 = "5"
private const val NUMBER_6 = "6"
private const val NUMBER_7 = "7"
private const val NUMBER_8 = "8"
private const val NUMBER_9 = "9"
private const val SUM = "+"
private const val DIFFERENCE = "-"
private const val MULTIPLICATION = "*"
private const val DIVISION = "/"
private const val EQUALLY = "="
private const val POINT = "."
private const val BRACKET_LEFT = "("
private const val BRACKET_RIGHT = ")"
private const val BACK = ""
private const val NUM_1 = 1


class CalculatorFragment : Fragment() {

    private val textField: TextView by lazy {
        requireActivity().findViewById(R.id.textField)
    }
    private val buttonNumber0: Button by lazy {
        requireActivity().findViewById(R.id.number_0)
    }
    private val buttonNumber1: Button by lazy {
        requireActivity().findViewById(R.id.number_1)
    }
    private val buttonNumber2: Button by lazy {
        requireActivity().findViewById(R.id.number_2)
    }
    private val buttonNumber3: Button by lazy {
        requireActivity().findViewById(R.id.number_3)
    }
    private val buttonNumber4: Button by lazy {
        requireActivity().findViewById(R.id.number_4)
    }
    private val buttonNumber5: Button by lazy {
        requireActivity().findViewById(R.id.number_5)
    }
    private val buttonNumber6: Button by lazy {
        requireActivity().findViewById(R.id.number_6)
    }
    private val buttonNumber7: Button by lazy {
        requireActivity().findViewById(R.id.number_7)
    }
    private val buttonNumber8: Button by lazy {
        requireActivity().findViewById(R.id.number_8)
    }
    private val buttonNumber9: Button by lazy {
        requireActivity().findViewById(R.id.number_9)
    }
    private val difference: Button by lazy {
        requireActivity().findViewById(R.id.difference)
    }
    private val sum: Button by lazy {
        requireActivity().findViewById(R.id.sum)
    }
    private val multiplication: Button by lazy {
        requireActivity().findViewById(R.id.multiplication)
    }
    private val division: Button by lazy {
        requireActivity().findViewById(R.id.division)
    }
    private val equally: Button by lazy {
        requireActivity().findViewById(R.id.equally)
    }
    private val bracketLeft: Button by lazy {
        requireActivity().findViewById(R.id.bracket1)
    }
    private val bracketRight: Button by lazy {
        requireActivity().findViewById(R.id.bracket2)
    }
    private val back: Button by lazy {
        requireActivity().findViewById(R.id.one_clear)
    }
    private val clear: Button by lazy {
        requireActivity().findViewById(R.id.all_clear)
    }
    private val point: Button by lazy {
        requireActivity().findViewById(R.id.point)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonNumber0.setOnClickListener {
            setTextFields(NUMBER_0)
        }
        buttonNumber1.setOnClickListener {
            setTextFields(NUMBER_1)
        }
        buttonNumber2.setOnClickListener {
            setTextFields(NUMBER_2)
        }
        buttonNumber3.setOnClickListener {
            setTextFields(NUMBER_3)
        }
        buttonNumber4.setOnClickListener {
            setTextFields(NUMBER_4)
        }
        buttonNumber5.setOnClickListener {
            setTextFields(NUMBER_5)
        }
        buttonNumber6.setOnClickListener {
            setTextFields(NUMBER_6)
        }
        buttonNumber7.setOnClickListener {
            setTextFields(NUMBER_7)
        }
        buttonNumber8.setOnClickListener {
            setTextFields(NUMBER_8)
        }
        buttonNumber9.setOnClickListener {
            setTextFields(NUMBER_9)
        }
        sum.setOnClickListener {
            setTextFields(SUM)
        }
        difference.setOnClickListener {
            setTextFields(DIFFERENCE)
        }
        multiplication.setOnClickListener {
            setTextFields(MULTIPLICATION)
        }
        division.setOnClickListener {
            setTextFields(DIVISION)
        }
        equally.setOnClickListener {
            setTextFields(EQUALLY)
        }
        point.setOnClickListener {
            setTextFields(POINT)
        }
        bracketLeft.setOnClickListener {
            setTextFields(BRACKET_LEFT)
        }
        bracketRight.setOnClickListener {
            setTextFields(BRACKET_RIGHT)
        }
        clear.setOnClickListener {
            textField.text = BACK
        }
        back.setOnClickListener {
            val str = textField.text.toString()
            if (str.isNotEmpty())
                textField.text = str.substring(0, str.length - NUM_1)
        }
        equally.setOnClickListener {
            try {
                val expression = ExpressionBuilder(textField.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    textField.text = longResult.toString()
                else textField.text = result.toString()
            } catch (e: Exception) {
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }
    }

    private fun setTextFields(str: String) {
        textField.append(str)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }
}