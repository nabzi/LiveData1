package com.example.livedata1

import android.content.Context
import kotlin.random.Random

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
           newQuestion(), newQuestion() , newQuestion()
        )
    }

    fun getQuestions() : List<Question>{
        return db!!.questionDao().getAll()
    }

   fun getQuestionsCount() = db!!.questionDao().getQuestionCount()

    fun getQuestion(num : Int) = db!!.questionDao().getQuestion(num)

    fun addQuestion() {
        db!!.questionDao().insertAll(
           newQuestion()
        )
    }
    fun newQuestion() : Question{
        var  a = Random.nextInt()
        var b = Random.nextInt()
        return  Question(0 , "$a - $b", a - b)
    }

}