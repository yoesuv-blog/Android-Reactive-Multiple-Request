package com.yoesuv.multiplerequest.menu.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yoesuv.multiplerequest.R
import com.yoesuv.multiplerequest.databinding.ItemListBinding
import com.yoesuv.multiplerequest.menu.models.PlaceModel
import com.yoesuv.multiplerequest.menu.viewmodels.ItemListViewModel

class ListPlaceAdapter: RecyclerView.Adapter<ListPlaceAdapter.PlaceViewHolder>() {

    private var listPlace: MutableList<PlaceModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PlaceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding = DataBindingUtil.inflate(inflater, R.layout.item_list, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bindView(listPlace[holder.adapterPosition])
    }

    fun addData(listData: MutableList<PlaceModel>){
        this.listPlace.clear()
        this.listPlace.addAll(listData)
    }

    class PlaceViewHolder(val binding: com.yoesuv.multiplerequest.databinding.ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(placeModel: PlaceModel){
            val viewModel = ItemListViewModel(placeModel)
            binding.itemPlace = viewModel
        }
    }
}