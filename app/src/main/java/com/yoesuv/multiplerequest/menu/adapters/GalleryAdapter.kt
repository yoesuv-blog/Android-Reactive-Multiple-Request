package com.yoesuv.multiplerequest.menu.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yoesuv.multiplerequest.R
import com.yoesuv.multiplerequest.databinding.ItemGridBinding
import com.yoesuv.multiplerequest.menu.models.GalleryModel

class GalleryAdapter: RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    private var listGallery: MutableList<GalleryModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GalleryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemGridBinding = DataBindingUtil.inflate(inflater, R.layout.item_grid, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listGallery.size
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bindView(listGallery[holder.adapterPosition])
    }

    fun addData(listData: MutableList<GalleryModel>) {
        this.listGallery.clear()
        this.listGallery.addAll(listData)
    }

    class GalleryViewHolder(val binding: ItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(galleryModel: GalleryModel) {

        }
    }
}