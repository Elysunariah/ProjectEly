package com.ely.projectely.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ely.projectely.R
import com.ely.projectely.adapter.MovieAdapter
import com.ely.projectely.model.Movie
import com.ely.projectely.model.MovieResult
import com.ely.projectely.service.ApiClient
import com.ely.projectely.service.MovieService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

//    lateinit var apiKey: String
//    var movies: MutableList<Movie> = mutableListOf()
//    var adapter = MovieAdapter(movies)
//    val movieService: MovieService = ApiClient.getClient()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)
//
//        rvMovie.layoutManager = LinearLayoutManager(applicationContext)
//        rvMovie.adapter = adapter
//
//        apiKey = getString(R.string.api_key)
//        getPopularMovies(apiKey)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.search_menu, menu)
//        val searchItem : MenuItem = menu.findItem(R.id.icon_search)
//        val searchView : SearchView= searchItem.actionView as SearchView
//
//        searchQuery(searchView)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            R.id.setting -> ""
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
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
//
//    fun getPopularMovies(apiKey: String) {
//         val call : retrofit2.Call<MovieResult> = movieService.getPopularMovies(apiKey)
//       getMovieData(call)
//    }
//
//    fun getMovieData(call : retrofit2.Call<MovieResult>) {
//        call.enqueue(object : retrofit2.Callback<MovieResult> {
//            override fun onFailure(call: retrofit2.Call<MovieResult>?, t: Throwable?) {
//                Toast.makeText(applicationContext, "${t.toString()}", Toast.LENGTH_SHORT).show()
//                Log.d("Movie Erorr", "${t?.message}")
//            }
//
//            override fun onResponse(call: retrofit2.Call<MovieResult>?, response: Response<MovieResult>?) {
//                if (response?.body() != null) {
//                    movies = response.body()!!.movies.toMutableList()
//                    adapter = MovieAdapter(movies)
//                    rvMovie.adapter = adapter
//                }
//                Log.d("Movie", "${response?.body()}")
//            }
//
//        })
//    }
}

