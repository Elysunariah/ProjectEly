package com.ely.projectely

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_grid.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class BukuAdapter(val context: Context, val list: List<BukuContract>) :
    RecyclerView.Adapter<BukuAdapter.ViewHolder>(){

    lateinit var itemview: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuAdapter.ViewHolder {
        itemview = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false)
        return ViewHolder(itemview)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BukuAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }
    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(bukuContract: BukuContract) {
            itemView.bukutittle.text = bukuContract.judul

            itemView.onClick {
                itemView.context.startActivity(itemView.context.intentFor<DetailBukuActivity>("buku" to bukuContract))
            }
        }
    }
}