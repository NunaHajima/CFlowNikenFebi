package com.example.cflow_project_nikenfebi

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Profile : Activity() {

    lateinit var out : Button
    lateinit var emailprofile : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        out = findViewById(R.id.btn_out)

        out.setOnClickListener{
            startActivity(Intent(this, OpeningSlide::class.java))
        }

    }
}