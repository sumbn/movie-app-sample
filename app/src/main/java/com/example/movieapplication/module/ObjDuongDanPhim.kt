package com.example.movieapplication.module

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class ObjDuongDanPhim : Serializable{
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("results")
    @Expose
    var results: List<DetailDuongDanPhim>? = null
}