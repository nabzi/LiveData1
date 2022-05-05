package com.example.livedata1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class QuestionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
        initList()
    }
    fun initList(){
        var adapter = QuestionAdapter() { question ->
            Toast.makeText(this, "click" , Toast.LENGTH_SHORT).show()
            //navigate to show question page , send question
        }
        var recyclerView = findViewById<RecyclerView>(R.id.rvQuestionList)
        recyclerView.adapter = adapter

//        var tmpList = listOf(
//            Question(1 , "question 1 description" , 10 ),
//            Question(2 , "question 2 description" , 20 ),
//            Question(3 , "question 3 description" , 30 ),
//            Question(4 , "question 4 description" , 40 )
//        )
//        adapter.submitList(tmpList)
//
//        var tmpList2 = listOf(
//            Question(1 , "question" , 10 ),
//            Question(2 , "question 2 description" , 20 ),
//            Question(4 , "question 4 description" , 40 )
//        )

//        adapter.submitList(tmpList2)


    }
}