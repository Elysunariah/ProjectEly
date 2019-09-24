package com.ely.projectely.FragmentBottomNav

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.ely.projectely.FragmentBottomNav.Tablayout.MyPagerAdapter
import com.ely.projectely.R
import com.ely.projectely.adapter.MovieAdapter
import com.ely.projectely.model.Movie
import com.ely.projectely.service.ApiClient
import com.ely.projectely.service.MovieService
import com.google.android.material.tabs.TabLayout
import java.util.zip.Inflater


class HomeFragment : Fragment() {
    lateinit var apiKey : String
    var movies : MutableList<Movie> = mutableListOf()
    var adapter = MovieAdapter(movies)
    val movieService : MovieService = ApiClient.getClient()

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

    companion object {
        fun newInstance(id: Int): HomeFragment {
            val fr = HomeFragment()
            val b = Bundle()
            fr.setArguments(b)
            return fr

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.search_menu, menu)

//        menu!!.findItem(R.id.action_settings).isVisible = false
//        menu!!.findItem(R.id.action_settings).isVisible = false

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == R.id.icon_search) {
            Toast.makeText(activity, "search", Toast.LENGTH_SHORT).show()
        }
        if (id == R.id.icon_menu) {
            Toast.makeText(activity, "menu", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

}


