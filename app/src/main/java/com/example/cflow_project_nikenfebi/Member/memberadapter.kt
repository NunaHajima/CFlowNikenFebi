package com.example.cflow_project_nikenfebi.Member

import android.content.Context
import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.cflow_project_nikenfebi.R
import java.util.jar.Attributes.Name

class memberadapter (var ctx: Context, var resource: Int, var item: ArrayList<modelmember>): ArrayAdapter<modelmember>(ctx, resource, item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(resource, null)

        val name = view.findViewById<TextView>(R.id.txt_membername)
        val typemember = view.findViewById<TextView>(R.id.txt_typemember)
        val Icon = view.findViewById<ImageView>(R.id.img_member3)

        name.text = item[position].Name
        typemember.text = item[position].TypeMember

        return view
    }
}