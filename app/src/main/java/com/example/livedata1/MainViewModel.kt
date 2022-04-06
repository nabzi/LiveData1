package com.example.livedata1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel(){
    var number = MutableLiveData (0)
    var question = MutableLiveData ( QuestionsRepository.questionList[0])
    fun nextQuestion() {
       // if ()
        number.value = number.value?.plus(1)
        number.value?.let{ number ->
            question.value = QuestionsRepository.questionList[number]
        }
    }


}