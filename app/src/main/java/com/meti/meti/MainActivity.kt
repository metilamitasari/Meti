package com.meti.meti

import android.content.Intent
import android.content.Intent.*
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_simple_intent = findViewById<Button>(R.id.btn_simple_intent)
        val btn_intent_with_data = findViewById<Button>(R.id.btn_intent_with_data)
        val btn_intent_parcelable = findViewById<Button>(R.id.btn_instent_parcelable)
        val btn_implicit_intent = findViewById<Button>(R.id.btn_implicit_intent)
        val btn_instent_Resul = findViewById<Button>(R.id.btn_intent_Result)

        btn_simple_intent.setOnClickListener {
            val simpleIntent = Intent(this@MainActivity,simpleActivity::class.java)
            startActivity(simpleIntent)
        }
        btn_intent_with_data.setOnClickListener {
            val intentwithdata = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
            startActivity(intentwithdata)
        }
        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "081528966846"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body","hello")
            startActivity(intent)
        }
        btn_instent_Resul.setOnClickListener {
            val Intent = Intent(this@MainActivity,ResultActivity::class.java)
            startActivityForResult(Intent, REQUEST_CODE)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode ==200) {
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_result.setBackgroundColor( Color.parseColor(color.toString()))
        }
    }
}