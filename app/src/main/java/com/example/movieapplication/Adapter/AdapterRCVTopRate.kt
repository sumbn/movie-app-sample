package com.example.movieapplication.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.MainActivity
import com.example.movieapplication.R
import com.example.movieapplication.module.DetailMovie

class AdapterRCVTopRate : RecyclerView.Adapter<AdapterRCVTopRate.MovieHolder> {
    constructor(list: MutableList<DetailMovie>,x:((DetailMovie)->Unit)) : super() {
        this.list = list
        this.onClick = x
    }
    private val onClick:(DetailMovie) -> Unit

    private val list: MutableList<DetailMovie>

    class MovieHolder : RecyclerView.ViewHolder {
        constructor(view: View,context:Context) : super(view){
            this.context = context
        }
        val imvPoster:ImageView = itemView.findViewById(R.id.imvPoster)
        val tvtitle: TextView = itemView.findViewById(R.id.tvtitle)
        val context:Context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.movie_item, parent, false)
        return MovieHolder(view,parent.context)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie:DetailMovie = list[position]
        Glide.with(holder.context).load("https://image.tmdb.org/t/p/w500/"+movie.posterPath).into(holder.imvPoster)
        holder.tvtitle.text = movie.title
        holder.imvPoster.setOnClickListener {
            onClick(movie)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
}