package com.meti.meti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        val btn_back = findViewById<Button>(R.id.btn_back)

        btn_back.setOnClickListener {
            val backIntent = Intent(this@ExplicitIntentActivity, MainActivity::class.java)
            startActivity(backIntent)
        }

    }
}