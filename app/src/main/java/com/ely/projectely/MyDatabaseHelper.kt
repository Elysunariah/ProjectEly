package com.ely.projectely

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

//TODO Buat dan atur kelas MyDatabaseHelper

class MyDatabaseHelper(context: Context) : ManagedSQLiteOpenHelper(context, "database_buku.db", null, 1){
    companion object{
        private var instance: MyDatabaseHelper? = null

        fun getInstance(context: Context): MyDatabaseHelper {
            if (instance == null) {
                instance =
                    MyDatabaseHelper(context)
            }
            return instance as MyDatabaseHelper
        }
    }
    override fun onCreate(db: SQLiteDatabase?) {
        //Buat table pada database
        db?.createTable(
            BukuContract.TABLE_BUKU,
            true,
            BukuContract.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            BukuContract.JUDUL to TEXT,
            BukuContract.ISIBUKU to TEXT,
            BukuContract.PHOTO to TEXT
        )

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(BukuContract.TABLE_BUKU, true)
    }

}
val Context.database: MyDatabaseHelper
    get() = MyDatabaseHelper.getInstance(
        applicationContext
    )