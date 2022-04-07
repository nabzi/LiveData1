package com.example.livedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    val vmodel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        var textView = findViewById<TextView>(R.id.tvNumber)
        var buttonNext = findViewById<Button>(R.id.button1)
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var questionText = findViewById<TextView>(R.id.tvQuestion)


        progressBar.max = vmodel.questionCount

        buttonNext.setOnClickListener {
           vmodel.nextClicked()
        }

        val numberObserver = Observer<Int> { number ->
                textView.text = number.toString()
                progressBar.progress = number
        }

        val buttonEnabledObserver = Observer<Boolean>{  enabled ->
            buttonNext.isEnabled = enabled
        }

        val questionObserver = Observer<String>{ question ->
            questionText.text = question
        }

        vmodel.questionLiveData.observe(this , questionObserver)
        vmodel.nextEnabledLiveData.observe(this , buttonEnabledObserver)
        vmodel.numberLiveData.observe(this , numberObserver)

    }
}