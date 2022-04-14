package com.example.livedata1

import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EndViewModel : ViewModel() {
    var score : Int = 100
    var age : Int? = 15
    var questionCount  = 10
    var user = User(1 , "zeinab")
    var scoreVisiblity = MutableLiveData<Boolean>(false)

    fun onShowScoreClick(){
        scoreVisiblity.value = true
    }

}
data class User(val id: Int, val name : String)