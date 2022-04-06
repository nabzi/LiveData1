package com.example.livedata1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel (app: Application) : AndroidViewModel(app){

    var number = MutableLiveData (0)
    var question = MutableLiveData ( QuestionsRepository.questionList[0])
     init{
         QuestionsRepository.initDB(app.applicationContext)
         QuestionsRepository.getQuestions()
     }
    fun nextQuestion() {
       // check if (question nu,ber is in range)
        number.value = number.value?.plus(1)
        number.value?.let{ number ->
            question.value = QuestionsRepository.questionList[number]
        }
    }


}