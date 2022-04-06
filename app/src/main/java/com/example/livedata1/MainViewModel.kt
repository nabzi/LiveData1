package com.example.livedata1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel(){
    var number = MutableLiveData (0)

    fun nextQuestion() {
        number.value = number.value?.plus(1)

    }


}