package com.ely.projectely

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activitydetail_buku.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.intentFor

class DetailBukuActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var buku: BukuContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitydetail_buku)

        buku = intent.getParcelableExtra<BukuContract>("buku")
        Log.d("BUKU", buku.toString())

        tvDetailJudul.text = buku.judul
        tvdetailBuku.text = buku.isibuku

        dsa_btn_delete.setOnClickListener(this)
        dsa_btn_update.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v) {
            dsa_btn_delete -> deleteData(buku.id)
            dsa_btn_update ->intentFor<UpdateBukuActivity>("buku" to buku)
        }
    }
    private fun deleteData(id: Long?) {
        database.use {
            delete(BukuContract.TABLE_BUKU, "${BukuContract.ID} = {id}", "id" to id!!.toInt())
        }
        finish()
    }


}