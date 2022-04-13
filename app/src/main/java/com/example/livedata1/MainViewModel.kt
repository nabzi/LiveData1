package com.example.livedata1

import android.app.Application
import androidx.lifecycle.*

class MainViewModel (app: Application) : AndroidViewModel(app){

    var number = MutableLiveData (1)
    var questionCount   = 0
    var question  =  MutableLiveData<Question?>()

     init{
         QuestionsRepository.initDB(app.applicationContext)
         questionCount = QuestionsRepository.getQuestionsCount()
         question.postValue( QuestionsRepository.getQuestion(1))
     }
    fun nextQuestion() {
       // check if (question nu,ber is in range)

        number.value?.let{ n ->
            if(n < questionCount) {
                number.value = n + 1
                question.value = QuestionsRepository.getQuestion(n+1)
            }
            //else disable next button
        }
    }


}