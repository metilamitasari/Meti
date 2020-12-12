package com.meti.meti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.rg_colors as rg_color1

class ResultActivity : AppCompatActivity() {
    companion object {
        const val RESULT_CODE = 200
        const val EXTRA_COLOR = "extra_color"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

         btn_result.setOnClickListener {
             if(rg_color1.checkedRadioButtonId != 0 ){
                 var value = "#000"
                 when(rg_color1.checkedRadioButtonId) {
                     R.id.rad_merah -> value ="#ff0000"
                     R.id.rad_biru -> value = "#0000ff"
                     R.id.rad_hijau -> value = "#00ff00"
                     R.id.rad_orange -> value = "FFFF98"
                 }
                 Log.d("selected color", value.toString())
                 val resultIntent = Intent()
                 resultIntent.putExtra(EXTRA_COLOR ,value)
                 setResult(200,resultIntent)
                 finish()
             }
         }
     }

}