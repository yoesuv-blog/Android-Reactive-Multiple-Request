package com.yoesuv.multiplerequest.menu.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.yoesuv.multiplerequest.menu.models.PlaceModel

class ItemListViewModel(placeModel: PlaceModel): ViewModel() {

    var title: ObservableField<String> = ObservableField(placeModel.nama)
    var location: ObservableField<String> = ObservableField(placeModel.lokasi)
    var thumbnail: ObservableField<String> = ObservableField(placeModel.thumbnail)

}