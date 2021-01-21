package com.example.nugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class activity_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var btn_order = findViewById<Button>(R.id.btn_order)
       btn_order.setOnClickListener(View.OnClickListener {
            var intent= Intent(this,activity_menu:: class.java)
            startActivity(intent)

        })
    }

}