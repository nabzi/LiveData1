package com.example.livedata1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel(){

    //var number = 0
    val numberLiveData = MutableLiveData<Int>(0)

    val questionLiveData = MutableLiveData<String>(
        QuestionRepository.questionList[0]
    )

    val questionCount = QuestionRepository.questionList.size

    var nextEnabledLiveData = MutableLiveData<Boolean>(true)

    fun nextClicked() {
        numberLiveData.value = numberLiveData.value?.plus(1)
        numberLiveData.value?.let{ number ->
            questionLiveData.value = QuestionRepository.questionList[number]
        }
    }


}