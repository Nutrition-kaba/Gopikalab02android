package com.example.gopikalab02android

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MViewModel
    private lateinit var movieAdapter: MAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MViewModel::class.java)

        val moviesRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        movieAdapter = MAdapter(viewModel.movies)
        moviesRecyclerView.adapter = movieAdapter
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.movies.observe(this, Observer { movies ->
            movieAdapter.notifyDataSetChanged()
        })

        val movieText = findViewById<EditText>(R.id.moviesText)
        val genreText = findViewById<EditText>(R.id.genreText)
        val addButton = findViewById<Button>(R.id.saveButton)
        addButton.setOnClickListener {

            val title = movieText.text.toString()
            val genre = genreText.text.toString()
            if (title.isNotBlank() && genre.isNotBlank()) {
            viewModel.addMovie(title, genre)
                movieText?.text?.clear()
                genreText?.text?.clear()
        }
            else{
                fun showToast(context: Context, message: String) {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                }
                showToast(this, "Title or Genre cannot be empty")

            }
        }
    }
}


/*       addButton.setOnClickListener {

           val title = movieText.text.toString()
           val genre = genreText.text.toString()
           if (title.isNotBlank() && genre.isNotBlank()) {
           viewModel.addMovie(title, genre)
           viewModel.movies.observe(this, Observer { movies ->
               moviesRecyclerView.adapter?.notifyDataSetChanged()
           })
               movieText?.text?.clear();
               genreText?.text?.clear();
           }
       }*/



