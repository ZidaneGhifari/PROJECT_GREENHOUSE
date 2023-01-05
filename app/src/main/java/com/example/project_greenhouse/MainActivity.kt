package com.example.project_greenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var handler = Handler ()
        handler.postDelayed({
            var intent = Intent(this@MainActivity, OneActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000 )
    }
}