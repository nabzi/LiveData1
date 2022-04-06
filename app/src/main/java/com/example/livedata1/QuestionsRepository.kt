package com.example.livedata1

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object QuestionsRepository {
    lateinit var db : AppDatabase
    fun initDB(context : Context){
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database1"
        ).allowMainThreadQueries()
            .build()
        val qDao = db.questionDao()
        qDao.insertAll(Question(0,"q1" , 1))
    }
    val questionList = arrayListOf (
        "question 1",
        "question 2" ,
        "question 3"
    )
    fun getQuestions() : List<Question>{
        return db.questionDao().getAll()
    }

}