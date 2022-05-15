package com.example.notesandrey.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notesandrey.calculator.viewmodel.CalculatorViewModel
import com.example.notesandrey.calculator.viewmodel.CalculatorViewModelFactory
import com.example.notesandrey.databinding.FragmentCalculatorBinding
import com.example.notesandrey.extensions.Numbers
import com.example.notesandrey.extensions.Operators


class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CalculatorViewModel by viewModels { CalculatorViewModelFactory() }

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

        viewModel.result.observe(viewLifecycleOwner) {
            binding.textField.text = it
        }

        binding.apply {
            number0.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_0)
            }
            number1.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_1)
            }
            number2.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_2)
            }
            number3.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_3)
            }
            number4.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_4)
            }
            number5.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_5)
            }
            number6.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_6)
            }
            number7.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_7)
            }
            number8.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_8)
            }
            number9.setOnClickListener {
                viewModel.setTextFields(Numbers.NUMBER_9)
            }
            sum.setOnClickListener {
                viewModel.setOperatorFields(Operators.SUM)
            }
            difference.setOnClickListener {
                viewModel.setOperatorFields(Operators.DIFFERENCE)
            }
            multiplication.setOnClickListener {
                viewModel.setOperatorFields(Operators.MULTIPLICATION)
            }
            division.setOnClickListener {
                viewModel.setOperatorFields(Operators.DIVISION)
            }
            equally.setOnClickListener {
                viewModel.setOperatorFields(Operators.EQUALLY)
            }
            point.setOnClickListener {
                viewModel.setOperatorFields(Operators.POINT)
            }
            bracket1.setOnClickListener {
                viewModel.setOperatorFields(Operators.BRACKET_LEFT)
            }
            bracket2.setOnClickListener {
                viewModel.setOperatorFields(Operators.BRACKET_RIGHT)
            }
            allClear.setOnClickListener {
                viewModel.clear()
            }
            oneClear.setOnClickListener {
                viewModel.calculatorOneClear(binding.textField.text.toString())
            }
            equally.setOnClickListener {
                viewModel.calculatorEqually(binding.textField.text.toString())
            }
        }
    }
}