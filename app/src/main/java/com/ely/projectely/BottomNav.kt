package com.ely.projectely

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ely.projectely.FragmentBottomNav.CreateFragment
import com.ely.projectely.FragmentBottomNav.HomeFragment
import com.ely.projectely.FragmentBottomNav.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class BottomNav : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_navigation)

        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        val actionBar = supportActionBar
        actionBar!!.title = "ENovel"


        // Memulai transaksi
        val ft = supportFragmentManager.beginTransaction()
// mengganti isi container dengan fragment baru
        ft.replace(R.id.container, HomeFragment())
// atau ft.add(R.id.your_placeholder, new FooFragment());
// mulai melakukan hal di atas (jika belum di commit maka proses di atas belum dimulai)
        ft.commit()
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    toolbar.title = "Home"
                    val homeFragment = HomeFragment.newInstance(1)
                    openFragment(homeFragment)
//                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_create -> {
                    toolbar.title = "Create"
                    val createFragment = CreateFragment.newInstance(2)
                    openFragment(createFragment)
//                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_user -> {
                    toolbar.title = "User"
                    val userFragment = UserFragment.newInstance(3)
                    openFragment(userFragment)
//                    return@OnNavigationItemSelectedListener true
                }
            }
            true
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

}



