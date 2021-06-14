package com.example.movieapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.Adapter.AdapterRCVTopRate
import com.example.movieapplication.Adapter.callAPITopRate
import com.example.movieapplication.module.DetailMovie
import com.example.movieapplication.module.ObjDuongDanPhim
import com.example.movieapplication.module.ObjTopRate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    private var dsMovie: MutableList<DetailMovie> = mutableListOf()
    private lateinit var adapterRCVTopRate: AdapterRCVTopRate
    private lateinit var rcvMovie: RecyclerView
    private lateinit var service: callAPITopRate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findView()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(callAPITopRate::class.java)
        service.getData("c3e5c77fbb1ecae0a2d8d7f0eb58395c").enqueue(object : Callback<ObjTopRate> {
            override fun onResponse(call: Call<ObjTopRate>, response: Response<ObjTopRate>?) {
                response?.body()?.results?.let { dsMovie.addAll(it) }
                adapterRCVTopRate.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ObjTopRate>, t: Throwable) {
            }
        })
        adapterRCVTopRate = AdapterRCVTopRate(dsMovie, {
            chuyenPage(it)
        })
        rcvMovie.layoutManager = GridLayoutManager(this, 3)
        rcvMovie.adapter = adapterRCVTopRate

    }

    fun findView() {
        rcvMovie = findViewById(R.id.rcvShow)
    }

    fun chuyenPage(detailMovie: DetailMovie) {
        val intent = Intent(this, DetailMovieScreen::class.java)
        intent.putExtra("object", detailMovie)
        startActivity(intent)
    }

}