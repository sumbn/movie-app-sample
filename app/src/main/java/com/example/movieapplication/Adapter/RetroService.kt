package com.example.movieapplication.Adapter

import com.example.movieapplication.module.RecyclerObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroService {

    //https://api.themoviedb.org/3/movie/top_rated?api_key=c3e5c77fbb1ecae0a2d8d7f0eb58395c
    @GET("top_rated?")
    fun getData(@Query("api_key") keyApi:String) : Call<RecyclerObject>
//    @GET("{x}/top_rated?api_key=c3e5c77fbb1ecae0a2d8d7f0eb58395c")
//    fun getData(@Path("x") x:String) : Call<ObjTopRate>

    //https://api.themoviedb.org/3/movie/724089/videos?api_key=c3e5c77fbb1ecae0a2d8d7f0eb58395c&language=en-US
    @GET("{idMovie}/videos?api_key=c3e5c77fbb1ecae0a2d8d7f0eb58395c&language=en-US")
    fun getDataDuongDan(@Path("idMovie") idMovie : Int?) : Call<RecyclerObject>
}