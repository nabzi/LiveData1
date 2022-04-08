package com.example.livedata1

import android.content.Context
import androidx.room.Room

object QuestionsRepository {
    var db : AppDatabase? = null
    var questionDao  : QuestionDao? = null

    fun initDB(context : Context){
        db = AppDatabase.getAppDataBase(context)

        questionDao = db?.questionDao()

        addTestData()
    }

    private fun addTestData() {
        questionDao?.insertAll(
            Question(1,"q1" , 1),
            Question(2,"q2" , 2)
        )
    }

    fun getQuestions() : List<Question>{
        return db!!.questionDao().getAll()
    }

}