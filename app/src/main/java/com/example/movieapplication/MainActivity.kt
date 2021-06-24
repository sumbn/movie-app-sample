package com.example.movieapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.movieapplication.databinding.ActivityMainBinding
import com.example.movieapplication.module.RecyclerObject


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val viewModel = makeApiCall()
        setUpBinding(viewModel)

    }
    fun setUpBinding(viewModel: MainActivityViewModel){

        binding.setVariable(BR.viewModel,viewModel)
        binding.executePendingBindings()
        binding.rcvShow.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            val decoration = DividerItemDecoration(this@MainActivity,VERTICAL)
            addItemDecoration(decoration)
        }
    }
    fun makeApiCall():MainActivityViewModel{
        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.recyclerListDataObserver().observe(this, Observer<RecyclerObject> {
            if (it != null) {
                //update the data
                viewModel.setAdapterData(it.results)
            } else {
                Toast.makeText(this@MainActivity, "Errors in fetching data", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeAPICall("c3e5c77fbb1ecae0a2d8d7f0eb58395c")
        return viewModel
    }


}