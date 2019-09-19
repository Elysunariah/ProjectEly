package com.ely.projectely.FragmentBottomNav

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.ely.projectely.FragmentBottomNav.Tablayout.MyPagerAdapter
import com.ely.projectely.FragmentBottomNav.Tablayout.TablayooutDua
import com.ely.projectely.FragmentBottomNav.Tablayout.TablayoutSatu
import com.ely.projectely.R
import com.ely.projectely.adapter.MovieAdapter
import com.ely.projectely.model.Movie
import com.ely.projectely.model.MovieResult
import com.ely.projectely.service.ApiClient
import com.ely.projectely.service.MovieService
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    lateinit var apiKey: String
    var movies: MutableList<Movie> = mutableListOf()
    var adapter = MovieAdapter(movies)
    val movieService: MovieService = ApiClient.getClient()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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
}


