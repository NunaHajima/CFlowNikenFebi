package com.example.cflow_project_nikenfebi.Transaction

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.example.cflow_project_nikenfebi.CreateTransaction.CreateTransaction
import com.example.cflow_project_nikenfebi.R
import com.example.cflow_project_nikenfebi.Transaction.apiTransaction.ApiTransaction
import com.example.cflow_project_nikenfebi.UpdateTransaction.UpdateActivity
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import com.example.cflow_project_nikenfebi.databinding.ActivityTransactionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionActivity : Activity() {

    lateinit var ListTransaction: ListView
    lateinit var createTransaction2: ImageView

    //val apiKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    val token = "Bearer $apiKey"

    var Items = ArrayList<ModelTransaction>()
    val CflowApi = RetrofitHelper.getInstance().create(ApiTransaction::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_transaction)

        ListTransaction = findViewById(R.id.listview_transaction)
        createTransaction2 = findViewById(R.id.btn_createTransaction)

        getItem()

        // untuk update
        ListTransaction.setOnItemClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as ModelTransaction
            val intent = Intent(this, UpdateActivity::class.java)
            intent.putExtra("id", item.Id)
            intent.putExtra("Customers", item.Customers)
            intent.putExtra("Date", item.Date)
            intent.putExtra("Nominal", item.Nominal.toString())
            intent.putExtra("Desc", item.Desc)
            intent.putExtra("Type", item.Type)
            startActivity(intent)
        }

        //untuk delete transaksi
        ListTransaction.setOnItemLongClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as ModelTransaction

            val builder = AlertDialog.Builder(this)
            builder.setMessage("Apakah kamu yakin ingin menghapus transaksi ini?")
                .setCancelable(false)
                .setPositiveButton("Ya") { dialog, id ->
                    val id = item.Id.toString()
                    var queryId = "eq.$id"
                    deleteItem(queryId)

                    //kalo udah klik yes
                    var Customers = item.Customers.toString()
                    Toast.makeText(
                        applicationContext,
                        "Berhasil menghapus transaksi dengan $Customers",
                        Toast.LENGTH_SHORT
                    ).show()

                    getItem()
                }
                .setNegativeButton("Tidak") { dialog, id ->
                    dialog.dismiss()
                }

            val alert = builder.create()
            alert.show()

            return@setOnItemLongClickListener true
        }

        // kalo mau buat transaksi lagi
        createTransaction2.setOnClickListener {
            val intent = Intent(this, CreateTransaction::class.java)
            startActivity(intent)
        }

    }

    fun setList(Items: ArrayList<ModelTransaction>) {
        val adapter = AdapterTransaction(this, R.layout.model_transaction, Items)
        ListTransaction.adapter = adapter
    }

    fun deleteItem(id: String) {
        CoroutineScope(Dispatchers.Main).launch {
            CflowApi.delete(token=token, apiKey=apiKey, idQuery=id)
        }
    }

    fun getItem() {
        CoroutineScope(Dispatchers.Main).launch {
            val response = CflowApi.get(token=token, apiKey=apiKey)
            Items = ArrayList<ModelTransaction>()

            response.body()?.forEach {
                Items.add(
                    ModelTransaction(
                        Id = it.id,
                        Customers = it.Customers,
                        Date = it.Date,
                        Nominal = it.Nominal,
                        Desc = it.Description,
                        Type = it.Type
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