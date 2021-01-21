package com.example.nugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var btn_masuk = findViewById<Button>(R.id.btn_masuk)
        btn_masuk.setOnClickListener(View.OnClickListener {

            var intent= Intent(this,activity_login:: class.java)
            startActivity(intent)

        })
    }

}