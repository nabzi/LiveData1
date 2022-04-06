package com.example.livedata1

import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel(){
    fun nextQuestion() {
        _number++
        //move progressbar
        //show number in  number text
    }

    private var _number = 0
    var number : Int = 0
        get() = _number


}