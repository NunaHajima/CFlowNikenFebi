package com.example.cflow_project_nikenfebi.ReceivList

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cflow_project_nikenfebi.CreateTransaction.CreateData
import com.example.cflow_project_nikenfebi.R
import com.example.cflow_project_nikenfebi.ReceivList.ApiReceiv.receivApi
import com.example.cflow_project_nikenfebi.ReceivList.ApiReceiv.receivdata
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.jar.Attributes.Name

class updatereceiv : Activity() {

    lateinit var updatename : EditText
    lateinit var updatenominal : EditText
    lateinit var simpanupdate : Button
    lateinit var id : String

   // val apiKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    //val token = "Bearer $apiKey"

    val receivapi = RetrofitHelper.getInstance().create(receivApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updatereceiv)

        updatename = findViewById(R.id.txt_updatenameReceiv)
        updatenominal = findViewById(R.id.txt_nominalupdatereceiv)
        simpanupdate = findViewById(R.id.btn_updatereceiv)

        id = intent.getStringExtra("id").toString()

        updatename.setText(intent.getStringExtra("name").toString())
        updatenominal.setText(intent.getStringExtra("nominal").toString())

        simpanupdate.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {

                val data = receivdata(
                    Name = updatename.text.toString(),
                    Nominal = updatenominal.text.toString().toInt())
                //val response = receivapi.update3(token = token, apiKey = apiKey, idQuery = "eq.$id", receivData = data)

                Toast.makeText(
                    applicationContext,
                    "Berhasil merubah Transaksi!",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}