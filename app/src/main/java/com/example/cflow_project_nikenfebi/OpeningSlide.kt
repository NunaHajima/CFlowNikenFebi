package com.example.cflow_project_nikenfebi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class OpeningSlide : Activity() {

    lateinit var btnLogIn: Button
    lateinit var btnRegistration: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening_slide)

        btnLogIn = findViewById(R.id.btn_ToLogInOS)
        btnRegistration = findViewById(R.id.btn_registrationOS)


        btnLogIn.setOnClickListener(){
            startActivity(Intent(this, LogIn::class.java))
        }

        btnRegistration.setOnClickListener(){
            startActivity(Intent(this, Registration::class.java))
        }
    }

    override fun onBackPressed() {

        Toast.makeText(
            applicationContext,
            "Kamu masih memiliki sesi",
            Toast.LENGTH_SHORT
        ).show()
    }
}