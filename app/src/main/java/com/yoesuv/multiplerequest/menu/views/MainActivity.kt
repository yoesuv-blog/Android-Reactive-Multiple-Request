package com.yoesuv.multiplerequest.menu.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.yoesuv.multiplerequest.R
import com.yoesuv.multiplerequest.data.Constants
import com.yoesuv.multiplerequest.databinding.ActivityMainBinding
import com.yoesuv.multiplerequest.menu.adapters.GalleryAdapter
import com.yoesuv.multiplerequest.menu.adapters.ListPlaceAdapter
import com.yoesuv.multiplerequest.menu.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var adapterList: ListPlaceAdapter
    private lateinit var adapterGrid: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecyclerViewList()
        setupRecyclerViewGrid()
        observeLiveData()

        viewModel.getData()
    }

    private fun setupRecyclerViewList() {
        adapterList = ListPlaceAdapter()
        binding.recyclerViewList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewList.adapter = adapterList
    }

    private fun setupRecyclerViewGrid(){
        adapterGrid = GalleryAdapter()
        val layoutManager = GridLayoutManager(this, 3)
        binding.recyclerViewGrid.layoutManager = layoutManager
        binding.recyclerViewGrid.adapter = adapterGrid
    }

    private fun observeLiveData() {
        viewModel.listPlace.observe(this, Observer { place ->
            Log.d(Constants.TAG_DEBUG,"MainActivity # list place count : ${place?.size}")
            adapterList.addData(place!!)
            adapterList.notifyDataSetChanged()
        })
        viewModel.listGallery.observe(this, Observer { gallery ->
            Log.d(Constants.TAG_DEBUG,"MainActivity # gallery count : ${gallery?.size}")
            adapterGrid.addData(gallery!!)
            adapterGrid.notifyDataSetChanged()
        })
    }
}
