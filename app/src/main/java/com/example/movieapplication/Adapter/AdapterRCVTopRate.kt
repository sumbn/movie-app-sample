package com.example.movieapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.R
import com.example.movieapplication.databinding.RecyclerviewRowBinding
import com.example.movieapplication.module.RecyclerData

class AdapterRCVTopRate : RecyclerView.Adapter<AdapterRCVTopRate.MovieHolder>() {
    lateinit var onClick: (RecyclerData) -> Unit
    var list = ArrayList<RecyclerData>()
    fun setData(list: ArrayList<RecyclerData>, x: ((RecyclerData) -> Unit)) {
        this.list = list
        this.onClick = x
    }

    class MovieHolder(val binding: RecyclerviewRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: RecyclerData) {
            binding.recyclerData = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewRowBinding.inflate(layoutInflater)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imvPoster : ImageView,url: String){
            Glide.with(imvPoster).load("https://image.tmdb.org/t/p/w500/"+ url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(imvPoster)
        }

    }
}

//@BindingAdapter("loadImage")
//fun loadImage(imvPoster: ImageView, url: String) {
//    Glide.with(imvPoster).load("https://image.tmdb.org/t/p/w500/" + url)
//        .circleCrop()
//        .placeholder(R.drawable.ic_launcher_background)
//        .error(R.drawable.ic_launcher_background)
//        .fallback(R.drawable.ic_launcher_background)
//        .into(imvPoster)
//}