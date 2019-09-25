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
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_create -> {
                    toolbar.title = "Create"
                    val createFragment = CreateFragment.newInstance(2)
                    openFragment(createFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_user -> {
                    toolbar.title = "User"
                    val userFragment = UserFragment.newInstance(3)
                    openFragment(userFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

//    fun showDialog(view: View) {
//        val  alertDialog = AlertDialog.Builder(this)
//            .setIcon(android.R.drawable.ic_btn_speak_now)
//            .setTitle("Are You sure to Exit")
//            .setMessage("if yes then application will close")
//            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, i ->
//                finish()
//            })
//            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, i ->
//                Toast.makeText(applicationContext, "Nothing Happened", Toast.LENGTH_SHORT).show()
//            })
//            .show()
//    }
}

//    private fun setupViewPager(viewPager: ViewPager) {
//        val adapter =ViewPagerAdapter(supportFragmentManager)
//        adapter.addFragment(HomeFragment(), "Home")
//        adapter.addFragment(AboutUsFragment(), "About Us")
//        adapter.addFragment(ContactUsFragment(),"Contact Us")
//        viewPager.adapter = adapter
//    }
//
//    internal inner class ViewPagerAdapter(manager: FragmentManager) :FragmentPagerAdapter(manager) {
//        private val mFragmentList = ArrayList<Fragment>()
//        private val mFragmentTittleList = ArrayList<String>()
//
//        override fun getItem(position: Int): Fragment {
//            return mFragmentList[position]
//
//        }
//
//        override fun getCount(): Int {
//            return mFragmentList.size
//        }
//
//        fun addFragment(fragment: Fragment, tittle : String) {
//            mFragmentList.add(fragment)
//            mFragmentTittleList.add(tittle)
//        }
//
//        override fun getPageTitle(position: Int): CharSequence? {
//            return mFragmentTittleList[position]

