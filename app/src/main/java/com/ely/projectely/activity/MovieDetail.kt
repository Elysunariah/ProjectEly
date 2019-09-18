package com.ely.projectely.activity

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ely.projectely.R
import com.ely.projectely.model.Movie
import com.ely.projectely.service.ApiClient
import kotlinx.android.synthetic.main.movie_detail.*
import retrofit2.Response
import javax.security.auth.callback.Callback

class MovieDetail : AppCompatActivity(){

    lateinit var apiKey : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        val intent = getIntent()
        val  movieId = intent.extras!!.get("movie_id")
        apiKey = getString(R.string.api_key)

        val movieService = ApiClient.getClient()
        val call : retrofit2.Call<Movie> = movieService.getMovieDetail(movieId.toString(), apiKey)
        call.enqueue(object : retrofit2.Callback<Movie> {
            override fun onResponse(call: retrofit2.Call<Movie>?, response: Response<Movie>?) {
                val movie = response?.body()
                if (movie != null) {
                    Log.d("Movie Detail", "${movie.title}")
                    var posterPath = StringBuilder()
                    posterPath.append(getString(R.string.poster_base_path)).append(movie.poster)
                    mvDtTitle.setText(movie.title)
                    mvDtStar.setText(movie.vote)
                    mvDtOverview.setText(movie.overview)
                    Glide.with(applicationContext).load(posterPath.toString()).into(mvDtImage)
                }
            }
            override fun onFailure(call: retrofit2.Call<Movie>?, t: Throwable?) {
                Log.d("Movie Detail Error", "${t?.message}")

            }
        })
    }
}