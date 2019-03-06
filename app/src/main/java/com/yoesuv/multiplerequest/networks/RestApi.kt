package com.yoesuv.multiplerequest.networks

import com.yoesuv.multiplerequest.menu.models.PlaceModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("List_place_malang_batu.json")
    fun getListPlace(): Observable<MutableList<PlaceModel>>
}