package com.ely.projectely

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.login_act.*

class LoginAct : AppCompatActivity() {

    private val RC_SIGN_IN = 7
    private lateinit var mGoogleSignIn: GoogleSignInClient
    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.login_act)

        fAuth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        )
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignIn = GoogleSignIn.getClient(this, gso)
        google_button.setOnClickListener {
            signIn()
        }

        tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginTwo::class.java))
        }

        btnCreateNew.setOnClickListener {
//            Toast('pindah ke halaman register')
            startActivity(Intent(this, CreateAccount::class.java))
        }
    }
    private fun signIn(){
        val signIntent = mGoogleSignIn.signInIntent
        startActivityForResult(signIntent, RC_SIGN_IN)
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        Log.d("FAUTH_LOGIN", "firebaseAuth : ${account.id}")

        val credential = GoogleAuthProvider.getCredential(account.idToken, null)

        fAuth.signInWithCredential(credential).addOnCompleteListener (this){
            if (it.isSuccessful){
                Toast.makeText(
                    this,
                    "Login Berhasil Welcome ${fAuth.currentUser!!.displayName}",
                    Toast.LENGTH_SHORT).show()
                val user = fAuth.currentUser
                updateUi(user)
            }else{
                Toast.makeText(
                    this,
                    "LOGIN GAGAL", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    private fun updateUi(user : FirebaseUser?) {
        if (user != null)
            Toast.makeText(
                this,
                "Login Berhasil Welcome ${user.displayName}",
                Toast.LENGTH_SHORT
            ).show()
        startActivity(Intent(this, BottomNav::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                Log.e("AUTH_LOGIN", "LOGIN_GAGAL", e)
            }
        }
    }
}