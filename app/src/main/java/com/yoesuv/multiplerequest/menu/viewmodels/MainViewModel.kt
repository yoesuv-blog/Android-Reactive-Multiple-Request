package com.yoesuv.multiplerequest.menu.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.yoesuv.multiplerequest.data.Constants
import com.yoesuv.multiplerequest.menu.models.GalleryModel
import com.yoesuv.multiplerequest.menu.models.PlaceModel
import com.yoesuv.multiplerequest.networks.ApplicationResponse
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    private val appResponse = ApplicationResponse()

    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var listPlace: MutableLiveData<MutableList<PlaceModel>> = MutableLiveData()
    var listGallery: MutableLiveData<MutableList<GalleryModel>> = MutableLiveData()

    fun getData() {
        isLoading.postValue(true)
        compositeDisposable.add(
            appResponse.getListPlace()
                .flatMap( object: Function<MutableList<PlaceModel>, ObservableSource<MutableList<PlaceModel>>> {
                    override fun apply(t: MutableList<PlaceModel>): ObservableSource<MutableList<PlaceModel>> {
                        Log.d(Constants.TAG_DEBUG,"MainViewModel # list place 1 -> size : ${t.size}")
                        listPlace.postValue(t)
                        return appResponse.getListPlaceDua()
                    }
                }).flatMap( object: Function<MutableList<PlaceModel>, ObservableSource<MutableList<GalleryModel>>> {
                    override fun apply(t: MutableList<PlaceModel>): ObservableSource<MutableList<GalleryModel>> {
                        Log.d(Constants.TAG_DEBUG,"MainViewModel # list place 2 -> size : ${t.size}")
                        //listPlace.postValue(t)
                        return appResponse.getListGallery()
                    }
                } )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response ->
                    Log.d(Constants.TAG_DEBUG,"MainViewModel # list gallery -> size : ${response.size}")
                    isLoading.postValue(false)
                    listGallery.postValue(response)
                },{ throwable ->
                    isLoading.postValue(false)
                    throwable.printStackTrace()
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}