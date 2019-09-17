package com.ely.projectely

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.create_account.*

class CreateAccount : AppCompatActivity() {

    var value = 0.0
    lateinit var fAuth: FirebaseAuth
    lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)
        fAuth = FirebaseAuth.getInstance()

        createLogin.setOnClickListener {
            startActivity(Intent(this, LoginTwo::class.java))
        }

        btnCreate.setOnClickListener {
            var nama = createNama.text.toString()
            var email = createEmail.text.toString()
            var password = createPass.text.toString()
            if (nama.isNotEmpty() || email.isNotEmpty() || password.isNotEmpty()) {
                fAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            simpanToFirebase(nama, email, password)
                            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this, "Value must 6 or more digit", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            } else {
                Toast.makeText(this, "There's is not empety input", Toast.LENGTH_SHORT).show()
            }
        }



//
//        btnCreate.setOnClickListener {
//            val nama = createNama.text.toString()
//            val email = createEmail.text.toString()
//            val pass = createPass.text.toString()
//            handlingForRegister(nama, email, pass)
//        }
//    }
//
//
//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }
//
//    private fun handlingForRegister(uname : String, email : String, pass : String) {
//        when {
//            uname.isEmpty() -> toast("username kosong")
//            email.isEmpty() -> ("email kosong")
//            pass.isEmpty() -> ("password kosong")
//            else -> alert(title = "REGISTRASI", message = "User Berhasil Registrasi") {
//                positiveButton(buttonText = "OK") {
//                    onBackPressed()
//                    finish()
//                }
//                isCancelable = false
//            }.show()
//        }
    }
    private fun simpanToFirebase(nama : String, emal : String, password : String) {
        val uidUser = fAuth.currentUser?.uid
        dbRef = FirebaseDatabase.getInstance().getReference("user/$uidUser")
        dbRef.child("/id").setValue(uidUser)
        dbRef.child("/nama").setValue(nama)
        dbRef.child("/email").setValue(emal)
        dbRef.child("/password").setValue(password)
        startActivity(Intent(this, BottomNav::class.java))
    }

}
