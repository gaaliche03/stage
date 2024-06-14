package com.example.stage.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.stage.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val log = findViewById<Button>(R.id.log)
        log.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val sign = findViewById<Button>(R.id.sign)
        sign.setOnClickListener {
            val intent1 = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent1)
        }
    }
}