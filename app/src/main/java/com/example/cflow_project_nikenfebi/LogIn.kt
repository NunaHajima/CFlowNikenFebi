package com.example.cflow_project_nikenfebi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LogIn : Activity() {

    lateinit var emaillogin : EditText
    lateinit var passwordmasuk : EditText
    lateinit var btnmasuklogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emaillogin = findViewById(R.id.inp_emailOS)
        passwordmasuk = findViewById(R.id.inp_passwordOS)
        btnmasuklogin = findViewById(R.id.btn_masukOS)

        btnmasuklogin.setOnClickListener{
            if (emaillogin.text.isEmpty()&&passwordmasuk.text.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Harap mengisi email dan password",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}