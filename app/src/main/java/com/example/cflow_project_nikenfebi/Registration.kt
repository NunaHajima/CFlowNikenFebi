package com.example.cflow_project_nikenfebi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registration : Activity() {

    lateinit var btnmasuk2 : Button
    lateinit var namatoko : EditText
    lateinit var emailmasuk : EditText
    lateinit var passwordregis : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnmasuk2 = findViewById(R.id.btn_masuk2)
        namatoko = findViewById(R.id.inp_namatoko)
        emailmasuk = findViewById(R.id.inp_emailOS)
        passwordregis = findViewById(R.id.inp_password2)

        btnmasuk2.setOnClickListener{
            if (namatoko.text.isEmpty()&&emailmasuk.text.isEmpty()&&passwordregis.text.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Harap lengkapi form Anda terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val intent = Intent(this, OpeningSlide::class.java)
            startActivity(intent)
        }

    }

}

