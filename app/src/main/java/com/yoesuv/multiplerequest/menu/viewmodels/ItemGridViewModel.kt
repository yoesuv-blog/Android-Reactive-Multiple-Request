package com.yoesuv.multiplerequest.menu.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.yoesuv.multiplerequest.menu.models.GalleryModel

class ItemGridViewModel(galleryModel: GalleryModel): ViewModel() {

    var thumbnail: ObservableField<String> = ObservableField(galleryModel.thumbnail)

}