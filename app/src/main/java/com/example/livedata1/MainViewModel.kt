package com.example.livedata1

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel (app: Application) : AndroidViewModel(app){

    var number = MutableLiveData (0)
    private lateinit var  questionList : List<Question>
    var question  = MutableLiveData<Question> ()
     init{
         QuestionsRepository.initDB(app.applicationContext)
         questionList = QuestionsRepository.getQuestions()
         question.value = questionList[0]
     }
    fun nextQuestion() {
       // check if (question nu,ber is in range)
        number.value = number.value?.plus(1)
        number.value?.let{ number ->
            question.value = questionList[number]
        }
    }


}