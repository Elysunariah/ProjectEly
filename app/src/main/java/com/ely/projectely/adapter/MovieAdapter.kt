package com.ely.projectely.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ely.projectely.R
import com.ely.projectely.activity.MovieDetail
import com.ely.projectely.model.Movie
import kotlinx.android.synthetic.main.movie_list.view.*
import java.lang.StringBuilder

class MovieAdapter (val movies  : List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder?.bindData(movies.get(position))

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MovieViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(view)

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val view  : View = itemView
        var movie : Movie? = null
        override fun onClick(v: View?) {
            val intent = Intent(view.context, MovieDetail::class.java)
            intent.putExtra("movie_id", movie?.id)
            view.context.startActivity(intent)
            Toast.makeText(view.context, "${movie?.title}", Toast.LENGTH_SHORT).show()
        }
        init {
            itemView.setOnClickListener(this)
        }

        fun bindData(movie: Movie) {
            this.movie = movie
            val posterBasePath = view.resources.getString(R.string.poster_base_path)
            var posterPath = StringBuilder()
            posterPath.append(posterBasePath).append(movie.poster)
            Glide.with(view.context).load(posterPath.toString()).into(view.mvImage)
            view.mvTitle.setText(movie.title)
            view.mvStar.setText(movie.vote)
        }

    }


}