package com.yoesuv.multiplerequest.networks

import com.yoesuv.multiplerequest.menu.models.PlaceModel
import io.reactivex.Observable

class ApplicationResponse {

    private val apiService = ServiceFactory.create()

    fun getListPlace(): Observable<MutableList<PlaceModel>> {
        return apiService.getListPlace()
    }
}