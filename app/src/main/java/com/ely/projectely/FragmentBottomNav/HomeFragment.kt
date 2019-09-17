package com.ely.projectely.FragmentBottomNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ely.projectely.FragmentBottomNav.Tablayout.TablayooutDua
import com.ely.projectely.FragmentBottomNav.Tablayout.TablayoutSatu
import com.ely.projectely.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_home)
//



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =

        inflater.inflate(R.layout.fragment_home, container, false)


    companion object {
        fun newInstance(id: Int): HomeFragment {
            val fr = HomeFragment()
            val b = Bundle()
            fr.setArguments(b)
            return fr

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//                setupViewPager(viewPager)

//        tabs!!.setupWithViewPager(viewPager)
    }

//    private fun setupViewPager(viewPager: ViewPager) {
//        val adapter = ViewPagerAdapter(supportFragmentManager)
//        adapter.addFragment(TablayoutSatu(), "Membaca")
//        adapter.addFragment(TablayooutDua(), "Daftar Buku")
//        viewPager.adapter = adapter
//    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) :
        FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]

        }

        override fun getCount(): Int {
            return mFragmentTitleList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }

    }
}


