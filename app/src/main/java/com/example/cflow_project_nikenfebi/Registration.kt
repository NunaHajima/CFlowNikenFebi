package com.example.cflow_project_nikenfebi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import com.example.cflow_project_nikenfebi.apiRegister.UserApi
import com.example.cflow_project_nikenfebi.apiRegister.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class Registration : Activity() {

    lateinit var btnmasuk2: Button
    lateinit var emailmasuk: EditText
    lateinit var passwordregis: EditText
    lateinit var btnbackOS: Button

    //val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    val token = "Bearer $apiKey"

    val userApi = RetrofitHelper.getInstance().create(UserApi::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnmasuk2 = findViewById(R.id.btn_masuk2)
        emailmasuk = findViewById(R.id.inp_emailOS)
        passwordregis = findViewById(R.id.inp_password2)
        btnbackOS = findViewById(R.id.btn_backOS)

        // ngedapetin nilai email dan password, lalu dimasukkan ke authentifikasi Supabase dengan nama suspend Daftar (UserAPI) dan mengubahnya ke string
        btnmasuk2.setOnClickListener {
            Daftar(emailmasuk.text.toString(), passwordregis.text.toString())
        }

        //Button ke Opening Slide
        btnbackOS.setOnClickListener {
            startActivity(Intent(this, OpeningSlide::class.java))
        }
    }

    private fun Daftar(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            var data = Users(email = email, password = password)
            var response = userApi.daftar(token = token, apiKey = apiKey, data = data)

            val bodyResponse = if (response.code() == 200) {
                response.body()?.string()
            } else {
                response.errorBody()?.string().toString()
            }

            var failed = false
            val jsonResponse = JSONObject(bodyResponse)
            if (jsonResponse.keys().asSequence().toList().contains("error")) {
                failed = true
            }
            var msg = ""
            if (!failed) {
                msg = "Registrasi kamu berhasil "
            } else {
                var errorMessage = jsonResponse.get("error_description")
                msg += errorMessage
            }
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(
                    applicationContext,
                    msg,
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    }

