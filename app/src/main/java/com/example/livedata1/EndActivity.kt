package com.example.livedata1


import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.livedata1.databinding.ActivityEndBinding

class EndActivity : AppCompatActivity() {
    val vmodel : EndViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityEndBinding  = DataBindingUtil.setContentView(this , R.layout.activity_end)
        binding.vmodel = vmodel
        binding.lifecycleOwner = this
    }
}
