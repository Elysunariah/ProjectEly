package com.ely.projectely.service

import android.telecom.Call
import com.ely.projectely.model.Movie
import com.ely.projectely.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieService {
    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey : String) : retrofit2.Call<MovieResult>
    @GET("search/movie")
    fun searchMovies(@QueryMap options : Map<String, String>) : retrofit2.Call<MovieResult>
    @GET("movie/{movie_id")
    fun getMovieDetail(@Path("movie_id") id : String, @Query("api_key") apiKey: String) : retrofit2.Call<Movie>
}