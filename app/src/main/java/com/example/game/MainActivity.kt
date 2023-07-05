package com.example.game

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        findViewById<ImageButton>(R.id.start_button).setOnClickListener {
            val intent = Intent(this, levelsactivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
