package com.example.livedata1

import android.content.Context

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
            Question(1,"Question 1" , 1),
            Question(2,"Question 2" , 2),
            Question(3,"Question 3" , 2)
        )
    }

    fun getQuestions() : List<Question>{
        return db!!.questionDao().getAll()
    }

   fun getQuestionsCount() = db!!.questionDao().getQuestionCount()

    fun getQuestion(num : Int) = db!!.questionDao().getQuestion(num)

}