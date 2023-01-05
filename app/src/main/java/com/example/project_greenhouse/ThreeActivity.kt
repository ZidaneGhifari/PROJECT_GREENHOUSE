package com.example.project_greenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_two.*

class ThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        btnBackLoginListener()
    }
    private fun btnBackLoginListener() {
        imageView6.setOnClickListener {
            startActivity(Intent(this, TwoActivity::class.java))
        }

        btnNextLoginListener()
    }
    private fun btnNextLoginListener() {
        imageView4.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
        }
    }
}