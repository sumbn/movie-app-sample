package com.example.movieapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapplication.Adapter.AdapterRCVTopRate
import com.example.movieapplication.Adapter.RetroInstance
import com.example.movieapplication.Adapter.RetroService
import com.example.movieapplication.module.RecyclerData
import com.example.movieapplication.module.RecyclerObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var recyclerList: MutableLiveData<RecyclerObject>
    var recyclerViewAdapter: AdapterRCVTopRate

    init {
        recyclerList = MutableLiveData()
        recyclerViewAdapter = AdapterRCVTopRate()
    }

    fun getAdapter(): AdapterRCVTopRate {
        return recyclerViewAdapter
    }

    fun setAdapterData(list: ArrayList<RecyclerData>) {
        recyclerViewAdapter.setData(list, {
            chuyenPage(it)
        })
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun recyclerListDataObserver(): MutableLiveData<RecyclerObject> {
        return recyclerList
    }

    fun makeAPICall(input: String) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getData(input)
        call.enqueue(object : Callback<RecyclerObject> {
            override fun onResponse(
                call: Call<RecyclerObject>,
                response: Response<RecyclerObject>
            ) {
                if (response.isSuccessful) {
                    recyclerList.postValue(response.body())

                } else {
                    recyclerList.postValue(null)
                }
            }

            override fun onFailure(call: Call<RecyclerObject>, t: Throwable) {
                recyclerList.postValue(null)
            }

        })


    }
    fun chuyenPage(recyclerData: RecyclerData) {
        Log.e("TAG", "chuyenPage: ")
    }
}

