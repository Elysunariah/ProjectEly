package com.ely.projectely.FragmentBottomNav

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ely.projectely.FragmentBottomNav.Tablayout.MyPagerAdapter
import com.ely.projectely.R
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {
    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        viewPager = view.findViewById(R.id.viewpager_main)
        tabs = view.findViewById(R.id.tabs_main)

        val fragmentAdapter = MyPagerAdapter(childFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)

        return view
    }

//    private lateinit var viewPager: ViewPager
//    private lateinit var tabs: TabLayout
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
//        viewPager = view.findViewById(R.id.viewpager_main)
//        tabs = view.findViewById(R.id.tabs_main)
//
//        val fragmentAdapter = MyPagerAdapter(childFragmentManager)
//        viewPager.adapter = fragmentAdapter
//        tabs.setupWithViewPager(viewPager)
//
//        return view
//    }


    companion object {
        fun newInstance(id: Int): HomeFragment {
            val fr = HomeFragment()
            val b = Bundle()
            fr.setArguments(b)
            return fr

        }
    }
}


