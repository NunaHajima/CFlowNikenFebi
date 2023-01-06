package com.example.cflow_project_nikenfebi.Transaction

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.example.cflow_project_nikenfebi.R

class AdapterTransaction (var ctx: Context, var resource: Int, var item: ArrayList<ModelTransaction>): ArrayAdapter<ModelTransaction>(ctx, resource, item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(resource, null)

        val Customers = view.findViewById<TextView>(R.id.inp_customermodel)
        val Date = view.findViewById<TextView>(R.id.inp_dateHome)
        val Nominal = view.findViewById<TextView>(R.id.inp_nominalHome)
        val Description = view.findViewById<TextView>(R.id.txt_descBawah)
        val img =  view.findViewById<ImageView>(R.id.img_logoTransaction)
        val typetransaksi = view.findViewById<TextView>(R.id.txt_typetransaksi)

        Customers.text = item[position].Customers
        Date.text = item[position].Date.toString()
        Nominal.text = item[position].Nominal.toString()
        Description.text = item[position].Desc
        typetransaksi.text = item[position].Type

        return view
    }
}