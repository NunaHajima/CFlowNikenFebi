package com.example.cflow_project_nikenfebi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.core.os.HandlerCompat.postDelayed

class OpeningSlide : Activity() {

    lateinit var btnloginOS : Button;
    lateinit var btnregistrasiOS : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening_slide)

        btnloginOS = findViewById(R.id.btn_loginOS)
        btnregistrasiOS = findViewById(R.id.btn_registrasiOS)

        btnloginOS.setOnClickListener(){
            startActivity(Intent(this, Masuk::class.java))
        }

        btnregistrasiOS.setOnClickListener(){
            startActivity(Intent(this, Registrasi2::class.java))
        }
    }
}