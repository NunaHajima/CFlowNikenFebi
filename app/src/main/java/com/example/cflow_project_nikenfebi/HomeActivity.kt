package com.example.cflow_project_nikenfebi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.cflow_project_nikenfebi.Member.Member
import com.example.cflow_project_nikenfebi.PayableList.PayableList
import com.example.cflow_project_nikenfebi.ReceivList.ReceivList
import com.example.cflow_project_nikenfebi.Transaction.TransactionActivity

class HomeActivity : Activity() {

    lateinit var Settings: ImageView
    lateinit var Saldo: TextView
    lateinit var Income: TextView
    lateinit var Outcome: TextView
    lateinit var btnMember: ImageButton
    lateinit var btnTransaction: ImageButton
    lateinit var btnPayable: ImageButton
    lateinit var btnReceivable: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Settings = findViewById(R.id.btn_settings)
        Saldo = findViewById(R.id.txt_rpsaldo)
        Income = findViewById(R.id.txt_ViewIncome)
        Outcome = findViewById(R.id.txt_OutcomeHome)
        btnMember = findViewById(R.id.btn_member)
        btnTransaction = findViewById(R.id.btn_toTransaction)
        btnPayable = findViewById(R.id.btn_payablelistHome)
        btnReceivable = findViewById(R.id.btn_receivlistHome)

        Settings.setOnClickListener{
           startActivity(Intent(this, Profile::class.java))
        }

        btnMember.setOnClickListener{
            startActivity(Intent(this, Member::class.java))
        }

        btnTransaction.setOnClickListener{
            startActivity(Intent(this, TransactionActivity::class.java))
        }

        btnPayable.setOnClickListener{
            startActivity(Intent(this, PayableList::class.java))
        }

        btnReceivable.setOnClickListener{
            startActivity(Intent(this, ReceivList::class.java))
        }

    }
}