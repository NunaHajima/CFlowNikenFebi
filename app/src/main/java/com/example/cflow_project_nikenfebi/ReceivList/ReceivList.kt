package com.example.cflow_project_nikenfebi.ReceivList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.example.cflow_project_nikenfebi.CreateTransaction.CreateTransaction
import com.example.cflow_project_nikenfebi.R
import com.example.cflow_project_nikenfebi.ReceivList.ApiReceiv.receivApi
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.jar.Attributes.Name

class ReceivList : Activity() {

    lateinit var listreceiv : ListView
    lateinit var createreceiv : ImageView

    //val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    //val token = "Bearer $apiKey"

    var Items = ArrayList<modelreceiv>()
    val receivapi = RetrofitHelper.getInstance().create(receivApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiv_list)
        listreceiv = findViewById(R.id.list_receivable)
        createreceiv = findViewById(R.id.create_receiv)

        getItem()

        listreceiv.setOnItemClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as modelreceiv
            val intent = Intent(this, updatereceiv::class.java)
            intent.putExtra("id", item.Id)
            intent.putExtra("name", item.Name)
            intent.putExtra("nominal", item.Nominal.toString())
            startActivity(intent)
        }

        createreceiv.setOnClickListener {
            startActivity(Intent(this, CreateReceiv::class.java))
        }
    }

    fun setList(Items: ArrayList<modelreceiv>) {
        val adapter = receivAdapter(this, R.layout.model_receiv, Items)
        listreceiv.adapter = adapter
    }

    fun getItem() {
        CoroutineScope(Dispatchers.Main).launch {
            //val response = receivapi.get3(token=token, apiKey=apiKey)
            Items = ArrayList<modelreceiv>()

            response.body()?.forEach {
                Items.add(
                    modelreceiv(
                        Id=it.id,
                        Name=it.nama,
                        Nominal = it.nominal
                    )
                )
            }

            setList(Items)
        }
    }

    override fun onResume() {
        super.onResume()
        getItem()
    }

}