package com.example.game

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class levelsactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levelsactivity)
        init()
    }

    private fun init() {

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.textView1).setOnClickListener {
            val intent = Intent(this, Level1::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.textView2).setOnClickListener {
            val intent = Intent(this, Level2::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.textView3).setOnClickListener {
            val intent = Intent(this, Level3::class.java)
            startActivity(intent)
            finish()
        }
    }
}
