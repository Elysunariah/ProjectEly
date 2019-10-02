package com.ely.projectely.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.ely.projectely.R

class Adapter (val mCtx: Context, val layoutResId: Int, val list: List<User>)
    :ArrayAdapter<User>(mCtx,layoutResId,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId,null)

        val textNama = view.findViewById<TextView>(R.id.bukutittle)
        val textStatus = view.findViewById<TextView>(R.id. isitittle)

        val user = list[position]

        textNama.text = user.judul
        textStatus.text = user.isi

        return view

    }
}