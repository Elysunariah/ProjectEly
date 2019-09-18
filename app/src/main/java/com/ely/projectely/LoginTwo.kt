package com.ely.projectely

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.login_two.*

class LoginTwo : AppCompatActivity() {

    private lateinit var fAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_two)
        supportActionBar!!.title = "Login"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        fAuth = FirebaseAuth.getInstance()

//        val actionBar = supportActionBar
//        actionBar!!.title = "Login"
//        actionBar.setDisplayHomeAsUpEnabled(true)
//        actionBar.setDisplayHomeAsUpEnabled(true)

        loginCreate.setOnClickListener {
            startActivity(Intent(this, CreateAccount::class.java))

        }


        fAuth = FirebaseAuth.getInstance()
        btn_loginTwo.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_psw.text.toString()

            if (!email.isNullOrEmpty() || !password.isNullOrEmpty()){
                fAuth.signInWithEmailAndPassword(email,password)
                    .addOnSuccessListener {
                        startActivity(Intent(this, BottomNav::class.java))
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "LOGIN GAGAL",
                            Toast.LENGTH_LONG).show()
                    }
            }else{
                Toast.makeText(this, " LOGIN GAGAL",
                    Toast.LENGTH_SHORT).show()
//                val intent = Intent (this, BottomNav::class.java)
//                startActivity(intent)
//                finish()
            }
        }
//
    }

//        override fun onSupportNavigateUp(): Boolean {
//            onBackPressed()
//            return true
//
//    }

//    private fun updateUI(user: FirebaseUser) {
//        if (user != null) {
//            Toast.makeText(
//                this, "Login berhasil welcome ${user.email}",
//                Toast.LENGTH_SHORT
//            ).show()
//            val email = user.email
//            if (email!!.split("@")[1] == "ely.com")
//                startActivity(Intent(this, BottomNav::class.java))
////            else
////                startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        val user = fAuth.currentUser
//        if (user != null) {
//            updateUI(user)
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        val user = fAuth.currentUser
//        if (user != null)
//            updateUI(user)
//
//        btn_loginTwo.setOnClickListener {
//            val email = et_email.text.toString()
//            val pass = et_psw.text.toString()
//            if (email.isNotEmpty() || pass.isNotEmpty()) {
//                fAuth.signInWithEmailAndPassword(email, pass)
//                    .addOnSuccessListener {
//                        FirebaseDatabase.getInstance().getReference("user")
//                            .addListenerForSingleValueEvent(object : ValueEventListener {
//                                override fun onCancelled(p0: DatabaseError) {
//                                }
//
//                                override fun onDataChange(p0: DataSnapshot) {
//                                    val user = fAuth.currentUser
//                                    if (user != null) {
//                                        updateUI(user)
//                                    }
//
//                                }
//
//                            })
//                    }
//                    .addOnFailureListener {
//                        Toast.makeText(
//                            this,
//                            "Login Gagal",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//            }else{
//                Toast.makeText(
//                    this,
//                    "Login Gagal",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//    }

}
