package com.example.cflow_project_nikenfebi.Member

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.example.cflow_project_nikenfebi.R
import com.example.cflow_project_nikenfebi.Transaction.ModelTransaction
import com.example.cflow_project_nikenfebi.apiRegister.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import memberApi
import java.util.jar.Attributes.Name

class Member : Activity() {

    lateinit var listmember : ListView
    lateinit var createmember1 : ImageView

    //val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZsbWJzeWJiaGF2aGhrbnlxbWV3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzA1NTcyNzQsImV4cCI6MTk4NjEzMzI3NH0.7xvyZDwE5TckY2ydzgA0zhIW153qP2CWUrn_OdAVhkk"
    val token = "Bearer $apiKey"

    var Items = ArrayList<modelmember>()
    val memberApi = RetrofitHelper.getInstance().create(memberApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)

        listmember = findViewById(R.id.list_membermember)
        createmember1 = findViewById(R.id.btn_createemmember)

        CoroutineScope(Dispatchers.Main).launch {
            val response = memberApi.get2(token=token, apiKey=apiKey)

            response.body()?.forEach {
                Items.add(
                    modelmember(
                        Id=it.id,
                        Name=it.Name,
                        TypeMember = it.TypeMember
                    )
                )
            }

            setList(Items)
        }

        createmember1.setOnClickListener{
            startActivity(Intent(this, crtmember::class.java))
        }

        //untuk delete transaksi
        listmember.setOnItemLongClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as modelmember

            val builder = AlertDialog.Builder(this)
            builder.setMessage("Apakah kamu yakin ingin menghapus data ini?")
                .setCancelable(false)
                .setPositiveButton("Ya") { dialog, id ->
                    val id = item.Id.toString()
                    var queryId = "eq.$id"
                    deleteItem(queryId)

                    //kalo udah klik yes
                    var member = item.Name.toString()
                    Toast.makeText(
                        applicationContext,
                        "Berhasil menghapus $member dari daftar",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .setNegativeButton("Tidak") { dialog, id ->
                    dialog.dismiss()
                }

            val alert = builder.create()
            alert.show()

            return@setOnItemLongClickListener true
        }


    }
    fun setList(Items: ArrayList<modelmember>) {
        val adapter = memberadapter(this, R.layout.member_item, Items)
        listmember.adapter = adapter
    }
    fun deleteItem(id: String) {
        CoroutineScope(Dispatchers.Main).launch {
            memberApi.delete2(token=token, apiKey=apiKey, idQuery=id)
        }
    }
}