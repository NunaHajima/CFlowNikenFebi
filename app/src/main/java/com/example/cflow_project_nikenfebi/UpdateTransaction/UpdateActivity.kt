package com.example.cflow_project_nikenfebi.UpdateTransaction

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.cflow_project_nikenfebi.CreateTransaction.CreateData
import com.example.cflow_project_nikenfebi.Member.modelmember
import com.example.cflow_project_nikenfebi.R
import com.example.cflow_project_nikenfebi.Transaction.ModelTransaction
import com.example.cflow_project_nikenfebi.Transaction.apiTransaction.ApiTransaction
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : Activity() {
    lateinit var Spinner2 : Spinner
    lateinit var CustomersUpd :  EditText
    lateinit var DateUpd : EditText
    lateinit var NominalUpd : EditText
    lateinit var DescUpd : EditText
    lateinit var btnUpdate : Button
    lateinit var typetransaksi : TextView
    lateinit var id : String

    //val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    //val token = "Bearer $apiKey"

    //berhenti sampai sini
    val CflowApi = RetrofitHelper.getInstance().create(ApiTransaction::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        Spinner2 = findViewById(R.id.spinner_type2)
        DateUpd = findViewById(R.id.upd_date)
        CustomersUpd = findViewById(R.id.upd_Customers)
        NominalUpd = findViewById(R.id.upd_nominal)
        DescUpd = findViewById(R.id.upd_desc)
        btnUpdate = findViewById(R.id.btn_Update)
        typetransaksi = findViewById(R.id.txt_ViewTypeTran)

        id = intent.getStringExtra("id").toString()

        typetransaksi.setText(intent.getStringExtra("Type").toString())
        DateUpd.setText(intent.getStringExtra("Date").toString())
        CustomersUpd.setText(intent.getStringExtra("Customers").toString())
        NominalUpd.setText(intent.getStringExtra("Nominal").toString())
        DescUpd.setText(intent.getStringExtra("Desc").toString())

        btnUpdate.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {

                val data = CreateData(Customers = CustomersUpd.text.toString(), Date = DateUpd.text.toString(), Nominal = NominalUpd.text.toString().toInt(), Description = DescUpd.text.toString(), Type = Spinner2.selectedItem.toString())
                //val response = CflowApi.update(token = token, apiKey = apiKey, idQuery = "eq.$id", createdata = data)

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
