package com.example.movieapplication.module

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class ObjDuongDanPhim {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("results")
    @Expose
    var results: List<DetailDuongDanPhim>? = null
}