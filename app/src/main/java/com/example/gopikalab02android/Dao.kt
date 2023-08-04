package com.example.gopikalab02android

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: MovieEntity)

    @Query("SELECT * FROM t_movies")
    fun getAllMovies(): LiveData<List<MovieEntity>>
}
