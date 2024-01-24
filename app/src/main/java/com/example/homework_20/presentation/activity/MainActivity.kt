package com.example.homework_20.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_20.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}