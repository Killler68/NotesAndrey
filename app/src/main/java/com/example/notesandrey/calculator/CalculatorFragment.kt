package com.example.notesandrey.calculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.databinding.FragmentCalculatorBinding
import com.example.notesandrey.extensions.Numbers
import com.example.notesandrey.extensions.Operators
import net.objecthunter.exp4j.ExpressionBuilder

private const val BACK = ("")

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            number0.setOnClickListener {
                setTextFields(Numbers.NUMBER_0)
            }
            number1.setOnClickListener {
                setTextFields(Numbers.NUMBER_1)
            }
            number2.setOnClickListener {
                setTextFields(Numbers.NUMBER_2)
            }
            number3.setOnClickListener {
                setTextFields(Numbers.NUMBER_3)
            }
            number4.setOnClickListener {
                setTextFields(Numbers.NUMBER_4)
            }
            number5.setOnClickListener {
                setTextFields(Numbers.NUMBER_5)
            }
            number6.setOnClickListener {
                setTextFields(Numbers.NUMBER_6)
            }
            number7.setOnClickListener {
                setTextFields(Numbers.NUMBER_7)
            }
            number8.setOnClickListener {
                setTextFields(Numbers.NUMBER_8)
            }
            number9.setOnClickListener {
                setTextFields(Numbers.NUMBER_9)
            }
            sum.setOnClickListener {
                setOperatorFields(Operators.SUM)
            }
            difference.setOnClickListener {
                setOperatorFields(Operators.DIFFERENCE)
            }
            multiplication.setOnClickListener {
                setOperatorFields(Operators.MULTIPLICATION)
            }
            division.setOnClickListener {
                setOperatorFields(Operators.DIVISION)
            }
            equally.setOnClickListener {
                setOperatorFields(Operators.EQUALLY)
            }
            point.setOnClickListener {
                setOperatorFields(Operators.POINT)
            }
            bracket1.setOnClickListener {
                setOperatorFields(Operators.BRACKET_LEFT)
            }
            bracket2.setOnClickListener {
                setOperatorFields(Operators.BRACKET_RIGHT)
            }
            allClear.setOnClickListener {
                textField.text = BACK
            }

            oneClear.setOnClickListener {
                calculatorOneClear()
            }
            equally.setOnClickListener {
                calculatorEqually()
            }
        }
    }

    private fun setTextFields(str: Numbers) {
        binding.textField.append(str.value)
    }

    private fun setOperatorFields(str: Operators) {
        binding.textField.append(str.value)
    }

    private fun calculatorOneClear() {
        val str = binding.textField.text.toString()
        if (str.isNotEmpty())
            binding.textField.text = str.removeRange(str.lastIndex..str.lastIndex)
    }

    private fun calculatorEqually() {
        try {
            val expression = ExpressionBuilder(binding.textField.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble())
                binding.textField.text = longResult.toString()
            else binding.textField.text = result.toString()
        } catch (e: Exception) {
            Log.d(this.javaClass.simpleName, e.message.toString())
        }
    }


}