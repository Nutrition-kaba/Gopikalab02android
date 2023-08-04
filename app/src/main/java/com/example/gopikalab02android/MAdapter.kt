package com.example.gopikalab02android


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView


class MAdapter (private val movies: LiveData<List<MovieEntity>>): RecyclerView.Adapter<MAdapter.MovieViewHolder>() {
    class MovieViewHolder(val view: View): RecyclerView.ViewHolder(view){

        val movieName: TextView = itemView.findViewById(R.id.movieText)
        val genre: TextView = itemView.findViewById(R.id.genreText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies.value?.get(position)
        holder.movieName.text= movie?.title
        holder.genre.text = movie?.genre
    }

    override fun getItemCount() = movies.value?.size ?: 0
}