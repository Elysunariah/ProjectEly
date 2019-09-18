package com.ely.projectely.FragmentBottomNav

import android.os.Bundle
import android.view.*
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.ely.projectely.BukuAdapter
import com.ely.projectely.BukuContract
import com.ely.projectely.FragmentBottomNav.Tablayout.MyPagerAdapter
import com.ely.projectely.FragmentBottomNav.Tablayout.TablayooutDua
import com.ely.projectely.FragmentBottomNav.Tablayout.TablayoutSatu
import com.ely.projectely.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.coroutines.selects.select
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.select


class UserFragment : Fragment() {
    private lateinit var viewPager : ViewPager
    private lateinit var tabs : TabLayout

//    var adapter: BukuAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_user, container, false)
        viewPager = view.findViewById(R.id.viewpager_main)
        tabs = view.findViewById(R.id.tabs_main)

        val fragmentAdapter = MyPagerAdapter(childFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)

        return view

    }



companion object {
    fun newInstance(id: Int): UserFragment {
        val fr = UserFragment()
        val b = Bundle()
        fr.setArguments(b)
        return fr
    }
}
    //                setupViewPager(viewPager)

//        tabs!!.setupWithViewPager(viewPager)


    //    private fun setupViewPager(viewPager: ViewPager) {
//        val adapter = ViewPagerAdapter(supportFragmentManager)
//        adapter.addFragment(TablayoutSatu(), "Membaca")
//        adapter.addFragment(TablayooutDua(), "Daftar Buku")
//        viewPager.adapter = adapter
//    }

//    internal inner class ViewPagerAdapter(manager: FragmentManager) :
//        FragmentPagerAdapter(manager) {
//        private val mFragmentList = ArrayList<Fragment>()
//        private val mFragmentTitleList = ArrayList<String>()
//
//        override fun getItem(position: Int): Fragment {
//            return mFragmentList[position]
//
//        }
//
//        override fun getCount(): Int {
//            return mFragmentTitleList.size
//        }
//
//        fun addFragment(fragment: Fragment, title: String) {
//            mFragmentList.add(fragment)
//            mFragmentTitleList.add(title)
//        }
//
//        override fun getPageTitle(position: Int): CharSequence? {
//            return mFragmentTitleList[position]
//        }
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        if(activity is AppCompatActivity){
//            (activity as AppCompatActivity).setSupportActionBar(Toolbar)
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.optionsmenu, menu)
        return
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()

        if (id == R.id.about) {
            Toast.makeText(activity!!.applicationContext, "About Click", Toast.LENGTH_SHORT).show()
            return true
        }
        if (id == R.id.setting) {
            Toast.makeText(activity!!.applicationContext, "Setting click", Toast.LENGTH_SHORT).show()
            return true
        }
        if (id == R.id.logout) {
            Toast.makeText(activity!!.applicationContext, "logout click", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}