package com.example.livedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    val vmodel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        var buttonNext = findViewById<Button>(R.id.button1)
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var numberText = findViewById<TextView>(R.id.tvNumber)
        var questionText = findViewById<TextView>(R.id.tvQuestion)
        buttonNext.setOnClickListener {
            vmodel.nextQuestion()
        }
        vmodel.number.observe(this ){
            progressBar.setProgress(it)
            numberText.text = it.toString()
        }
        vmodel.question.observe(this ){
            questionText.text = it
        }
    }
}