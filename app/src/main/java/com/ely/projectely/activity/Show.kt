package com.ely.projectely.activity

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.ely.projectely.R
import com.google.firebase.database.*

class Show : AppCompatActivity(){

//    lateinit var ref : DatabaseReference
//    lateinit var list : MutableList<User>
//    lateinit var listView: ListView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.item_grid)
//
//        ref = FirebaseDatabase.getInstance().getReference("USER")
//        list = mutableListOf()
//        listView = findViewById(R.id.listView)
//
//        ref.addValueEventListener(object : ValueEventListener{
//            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onDataChange(p0: DataSnapshot) {
//                if (p0!!.exists()){
//
//                    for (h in p0.children){
//                        val user = h.getValue(User::class.java)
//                        list.add(user!!)
//                    }
//                    val adapter = Adapter(applicationContext, R.layout.user,list)
//                    listView.adapter = adapter
//                }
//            }
//
//        })
//    }
}