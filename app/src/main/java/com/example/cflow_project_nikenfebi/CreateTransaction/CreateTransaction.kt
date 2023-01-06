package com.example.cflow_project_nikenfebi.CreateTransaction

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.cflow_project_nikenfebi.R
import com.example.cflow_project_nikenfebi.Transaction.apiTransaction.ApiTransaction
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CreateTransaction : Activity() {

    lateinit var btnSavetoHome : Button
    lateinit var dateIncome : EditText
    lateinit var customernameIncome : EditText
    lateinit var nominalIncome : EditText
    lateinit var descIncome : EditText
    lateinit var spinnerType : Spinner

    //val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    val token = "Bearer $apiKey"

    val CflowApi = RetrofitHelper.getInstance().create(ApiTransaction::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val intentReceived = intent
        val apakahMenyimpan = intentReceived.getBooleanExtra("KEY_SAVE_USE", false)

        btnSavetoHome = findViewById(R.id.btn_saveIncome)
        dateIncome = findViewById(R.id.inp_dateIncome)
        customernameIncome = findViewById(R.id.inp_customernameIncome)
        nominalIncome = findViewById(R.id.inp_nominal)
        descIncome = findViewById(R.id.inp_deskripsi)
        spinnerType = findViewById(R.id.spiner_typeTransaction)

        btnSavetoHome.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                val data = CreateData(
                    Date = dateIncome.text.toString(),
                    Customers = customernameIncome.text.toString(),
                    Nominal = nominalIncome.text.toString().toInt(),
                    Description = descIncome.text.toString(),
                    Type = spinnerType.selectedItem.toString()
                )
                val response = CflowApi.create(token = token, apiKey = apiKey, createdata = data)

                Toast.makeText(
                    applicationContext,
                    "Transaksi berhasil dibuat",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }

        }

        spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected( adapterView: AdapterView<*>?, view: View?, position : Int, id : Long){

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }
}
