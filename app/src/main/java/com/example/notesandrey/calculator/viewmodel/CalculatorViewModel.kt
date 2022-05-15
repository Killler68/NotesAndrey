package com.example.notesandrey.calculator.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesandrey.extensions.Numbers
import com.example.notesandrey.extensions.Operators
import net.objecthunter.exp4j.ExpressionBuilder


private const val BACK = ("")

class CalculatorViewModel : ViewModel() {

    private var _result: MutableLiveData<String> = MutableLiveData()
    val result: LiveData<String> get() = _result

    fun calculatorEqually(outPutText: String) {
        try {
            val expression = ExpressionBuilder(outPutText).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble())
                _result.postValue(longResult.toString())
            else _result.postValue(result.toString())
        } catch (e: Exception) {
            Log.d(this.javaClass.simpleName, e.message.toString())
        }
    }

    fun setTextFields(str: Numbers) {
        val oldStr = if (_result.value != null) _result.value else ""
        _result.postValue(oldStr + str.value)
    }

    fun setOperatorFields(str: Operators) {
        val oldStr = if (_result.value != null) _result.value else ""
        _result.postValue(oldStr + str.value)
    }

    fun calculatorOneClear(oneClear: String) {
        if (oneClear.isNotEmpty())
            _result.postValue(oneClear.removeRange(oneClear.lastIndex..oneClear.lastIndex))
    }

    fun clear() {
        _result.postValue(BACK)
    }
}