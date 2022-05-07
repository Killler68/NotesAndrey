package com.example.notesandrey.calculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.R
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
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCalculatorBinding.bind(view)
        binding.number0.setOnClickListener {
            setTextFields(Numbers.NUMBER_0)
        }
        binding.number1.setOnClickListener {
            setTextFields(Numbers.NUMBER_1)
        }
        binding.number2.setOnClickListener {
            setTextFields(Numbers.NUMBER_2)
        }
        binding.number3.setOnClickListener {
            setTextFields(Numbers.NUMBER_3)
        }
        binding.number4.setOnClickListener {
            setTextFields(Numbers.NUMBER_4)
        }
        binding.number5.setOnClickListener {
            setTextFields(Numbers.NUMBER_5)
        }
        binding.number6.setOnClickListener {
            setTextFields(Numbers.NUMBER_6)
        }
        binding.number7.setOnClickListener {
            setTextFields(Numbers.NUMBER_7)
        }
        binding.number8.setOnClickListener {
            setTextFields(Numbers.NUMBER_8)
        }
        binding.number9.setOnClickListener {
            setTextFields(Numbers.NUMBER_9)
        }
        binding.sum.setOnClickListener {
            setOperatorFields(Operators.SUM)
        }
        binding.difference.setOnClickListener {
            setOperatorFields(Operators.DIFFERENCE)
        }
        binding.multiplication.setOnClickListener {
            setOperatorFields(Operators.MULTIPLICATION)
        }
        binding.division.setOnClickListener {
            setOperatorFields(Operators.DIVISION)
        }
        binding.equally.setOnClickListener {
            setOperatorFields(Operators.EQUALLY)
        }
        binding.point.setOnClickListener {
            setOperatorFields(Operators.POINT)
        }
        binding.bracket1.setOnClickListener {
            setOperatorFields(Operators.BRACKET_LEFT)
        }
        binding.bracket2.setOnClickListener {
            setOperatorFields(Operators.BRACKET_RIGHT)
        }
        binding.allClear.setOnClickListener {
            binding.textField.text = BACK
        }
        binding.oneClear.setOnClickListener {
            val str = binding.textField.text.toString()
            if (str.isNotEmpty())
                binding.textField.text = str.removeRange(str.lastIndex..str.lastIndex)
        }
        binding.equally.setOnClickListener {
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

    private fun setTextFields(str: Numbers) {
        binding.textField.append(str.value)
    }

    private fun setOperatorFields(str: Operators) {
        binding.textField.append(str.value)
    }


}