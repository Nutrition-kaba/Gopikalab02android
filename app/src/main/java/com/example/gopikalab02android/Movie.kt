package com.example.gopikalab02android

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val genre: String
)