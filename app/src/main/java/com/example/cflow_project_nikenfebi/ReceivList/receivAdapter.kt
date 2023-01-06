package com.example.cflow_project_nikenfebi.ReceivList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.cflow_project_nikenfebi.R

class receivAdapter (var ctx: Context, var resource: Int, var item: ArrayList<modelreceiv>): ArrayAdapter<modelreceiv>(ctx, resource, item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(resource, null)

        val Name = view.findViewById<TextView>(R.id.txt_namareceivable)
        val Nominal = view.findViewById<TextView>(R.id.txt_nominalreceivable)

        Name.text = item[position].Name
        Nominal.text = item[position].Nominal.toString()

        return view
    }
}