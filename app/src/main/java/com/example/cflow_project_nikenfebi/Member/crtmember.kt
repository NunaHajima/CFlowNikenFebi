package com.example.cflow_project_nikenfebi.Member

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.cflow_project_nikenfebi.Member.Apimember.memberdata
import com.example.cflow_project_nikenfebi.R
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import memberApi

class crtmember : Activity() {

    lateinit var spinnermember : Spinner
    lateinit var namememberinput : EditText
    lateinit var btncreatemember2 : Button

    //val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    val token = "Bearer $apiKey"

    val memberApi = RetrofitHelper.getInstance().create(memberApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createmember)

        spinnermember = findViewById(R.id.spinner_typemember)
        namememberinput = findViewById(R.id.inp_namemember)
        btncreatemember2 = findViewById(R.id.save_member)

        btncreatemember2.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                val data = memberdata(
                    Name = namememberinput.text.toString(),
                    TypeMember = spinnermember.selectedItem.toString()
                )
                val response = memberApi.create2(token = token, apiKey = apiKey, memberdata = data)

                Toast.makeText(
                    applicationContext,
                    "Transaksi berhasil dibuat",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }

        spinnermember.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position : Int, id : Long){

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }
}