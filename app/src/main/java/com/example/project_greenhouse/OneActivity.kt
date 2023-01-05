package com.example.project_greenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_one.*

class OneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        btnNextLoginListener()
    }
    private fun btnNextLoginListener() {
        imageView4.setOnClickListener {
            startActivity(Intent(this, TwoActivity::class.java))
        }
    }
}