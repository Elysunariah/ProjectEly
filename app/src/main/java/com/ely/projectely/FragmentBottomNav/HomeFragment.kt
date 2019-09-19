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

        private lateinit var viewPager : ViewPager
    private lateinit var tabs : TabLayout

    lateinit var apiKey: String
    var movies: MutableList<Movie> = mutableListOf()
    var adapter = MovieAdapter(movies)
    val movieService: MovieService = ApiClient.getClient()



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

                viewPager = view.findViewById(R.id.viewpager_main)
                tabs = view.findViewById(R.id.tabs_main)

                val fragmentAdapter = MyPagerAdapter(childFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)

//        rvMovie.layoutManager = LinearLayoutManager(activity!!.applicationContext)
//        rvMovie.adapter = adapter


//        apiKey = getString(R.string.api_key)
//        getPopularMovies(apiKey)

    }
    

//    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
//        inflater!!.inflate(R.menu.search_menu, menu)
//        val searchItem : MenuItem = menu!!.findItem(R.id.icon_search)
//        val searchView : SearchView = searchItem.actionView as SearchView
//
//        searchQuery(searchView)
//        super.onCreateOptionsMenu(menu, inflater)
//    }
//    private fun searchQuery(searchView: SearchView) {
//        var options : MutableMap<String, String> = mutableMapOf()
//        options.put("api_key", apiKey)
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (query.isNullOrEmpty()) {
//                    return false
//                }
//
//                options.put("query", query!!.toString())
//                val call : retrofit2.Call<MovieResult> = movieService.searchMovies(options)
//                getMovieData(call)
//
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//        })
//    }
//    fun getMovieData(call : retrofit2.Call<MovieResult>) {
//        call.enqueue(object : retrofit2.Callback<MovieResult> {
//            override fun onFailure(call: retrofit2.Call<MovieResult>?, t: Throwable?) {
//                Toast.makeText(activity!!.applicationContext, "${t.toString()}", Toast.LENGTH_SHORT).show()
//                Log.d("Movie Erorr", "${t?.message}")
//            }
//
//            override fun onResponse(call: retrofit2.Call<MovieResult>?, response: Response<MovieResult>?) {
//                if (response?.body() != null) {
//                    movies = response.body()!!.movies.toMutableList()
//                    adapter = MovieAdapter(movies)
////                    rvMovie.adapter = adapter
//                }
//                Log.d("Movie", "${response?.body()}")
//            }
//
//        })
//    }
//    fun getPopularMovies(apiKey: String) {
//        val call : retrofit2.Call<MovieResult> = movieService.getPopularMovies(apiKey)
//        getMovieData(call)
//    }
}


