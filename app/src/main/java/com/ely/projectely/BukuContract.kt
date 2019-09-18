package com.ely.projectely

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//TODO 7 Buat sebuah kelas model

@Parcelize
data class BukuContract(
    val id: Long?,
    val judul: String,
    val photo: String?,
    val isibuku: String

) : Parcelable {
    companion object{
        const val TABLE_BUKU = "table_buku"
        const val ID = "id"
        const val JUDUL = "judul"
        const val ISIBUKU = "isibuku"
        const val PHOTO = "photo"
    }
}