package com.example.movieapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movieapplication.module.DetailMovie

class DetailMovieScreen:AppCompatActivity() {
    private lateinit var imvPhim : ImageView
    private lateinit var rbRating : RatingBar
    private lateinit var tvOverView: TextView
    private lateinit var btnWatch: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_movie)
        findView()
        var movie = getIntent().getSerializableExtra("object") as DetailMovie
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+movie.backdropPath)
            .into(imvPhim)
        rbRating.rating = movie.voteAverage!!/2
        tvOverView.text = movie.overview
    }
    fun findView(){
        imvPhim = findViewById(R.id.imvPhim)
        rbRating = findViewById(R.id.rbRating)
        tvOverView = findViewById(R.id.tvOverview)
        btnWatch = findViewById(R.id.btnWatch)
    }
}