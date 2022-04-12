package com.example.livedata1

import android.content.Context
import androidx.lifecycle.LiveData

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

    fun deleteQuestion(q : Question) = db!!.questionDao().delete(q)

    fun getQuestionLiveData() : LiveData<Question>
    {
        return db!!.questionDao().getQuestionLiveData(1)
    }

    fun getQuestion() : Question?
    {
       return db!!.questionDao().getQuestion(1)
    }

    fun add(q: Question) {
        db!!.questionDao().insertAll(q)
    }


}