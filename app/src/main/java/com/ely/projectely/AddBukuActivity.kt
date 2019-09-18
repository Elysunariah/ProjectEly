package com.ely.projectely

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_create.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class AddBukuActivity: AppCompatActivity() {
//    //TODO Buat dan atur kelas AddStudentActivity buat fungsi : validasi dan insertDatabase
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_create)
//
//        btnSimpan.onClick {
//            if (!validation()){
//                return@onClick
//            }
//            insertDatabase()
//        }
//    }
//    private fun insertDatabase() {
//        database.use {
//            insert(BukuContract.TABLE_BUKU,
//                BukuContract.JUDUL to et_judul.text.toString(),
//                BukuContract.PHOTO to null,
//                BukuContract.ISIBUKU to etMenulis.text.toString()
//            )
//
//            toast("Berhasil Menambahkan")
//        }
//    }
//    private fun validation(): Boolean {
//        when {
//            et_judul.text.toString().isNotBlank() -> {
//                et_judul.requestFocus()
//                et_judul.error = "tidak boleh kosong"
//                return false
//            }
//            etMenulis.text.toString().isNotBlank() -> {
//                etMenulis.requestFocus()
//                return false
//            }
//            else -> return true
//        }
//
//    }
}