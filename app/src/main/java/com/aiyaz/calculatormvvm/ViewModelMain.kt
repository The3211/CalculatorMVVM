package com.aiyaz.calculatormvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelMain : ViewModel() {
    private var totalValueMutable = MutableLiveData<String>()
    public val totalValue : LiveData<String>
    get() = totalValueMutable


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

    fun clearCalcStr(){
        totalValueMutable.value = ""
    }

    fun setOperation(){

    }

}