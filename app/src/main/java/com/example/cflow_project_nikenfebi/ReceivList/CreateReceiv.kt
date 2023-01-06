package com.example.cflow_project_nikenfebi.ReceivList

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cflow_project_nikenfebi.R
import com.example.cflow_project_nikenfebi.ReceivList.ApiReceiv.receivApi
import com.example.cflow_project_nikenfebi.ReceivList.ApiReceiv.receivdata
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateReceiv : Activity() {

    lateinit var namapelanggan : EditText
    lateinit var nominalreceiv : EditText
    lateinit var simpanreceive : Button

    //val apiKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    val token = "Bearer $apiKey"

    val receivapi = RetrofitHelper.getInstance().create(receivApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_receiv)

        namapelanggan = findViewById(R.id.txt_namereciv)
        nominalreceiv = findViewById(R.id.txt_nominalreceiv)
        simpanreceive = findViewById(R.id.btn_createreceiv)


        simpanreceive.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val data = receivdata(
                    Name = namapelanggan.text.toString(),
                    Nominal = nominalreceiv.text.toString().toInt()
                )
                val response = receivapi.create3(token = token, apiKey = apiKey, receivData = data)

                Toast.makeText(
                    applicationContext,
                    "Data berhasil disimpan",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}