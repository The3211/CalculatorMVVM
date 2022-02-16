package com.aiyaz.calculatormvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelMain : ViewModel() {
    private var totalValueMutable = MutableLiveData<String>()
    val totalValue : LiveData<String>
    get() = totalValueMutable

    var calcOperations = CalcOperations.NotDefined

    private var firstCalcArg = 0.0
    private var secondCalcArg = 0.0

    fun setCalcStr(passedVal : String){
        val passedValueInt = passedVal.toIntOrNull()?:-1
        if(passedValueInt > -1){
            if(totalValueMutable.value == null){
                totalValueMutable.value = passedVal
            }else {
                totalValueMutable.value = "${totalValueMutable.value}${passedVal}"
            }
        }else{

        }
    }

    private fun clearCalcStr(){
        totalValueMutable.value = ""
    }

    fun clearVariablesAndStr(){
        totalValueMutable.value = ""
        firstCalcArg = 0.0
        secondCalcArg = 0.0
    }

    fun setOperation(calcOperations : CalcOperations){
        this.calcOperations = calcOperations
        firstCalcArg = totalValueMutable.value?.toDoubleOrNull()?:0.0
        clearCalcStr()
    }

    fun onEqualClickOperation(){
        secondCalcArg = totalValueMutable.value?.toDoubleOrNull()?:0.0
        calculateOperations()
    }

    private fun calculateOperations(){
        when (calcOperations) {
            CalcOperations.Plus -> {
                totalValueMutable.value = firstCalcArg.plus(secondCalcArg).toString()
            }
            CalcOperations.Minus -> {
                totalValueMutable.value = firstCalcArg.minus(secondCalcArg).toString()
            }
            CalcOperations.Multiply -> {
                totalValueMutable.value = (firstCalcArg * secondCalcArg).toString()
            }
            CalcOperations.Divide -> {
                totalValueMutable.value = firstCalcArg.div(secondCalcArg).toString()
            }
        }
    }


}