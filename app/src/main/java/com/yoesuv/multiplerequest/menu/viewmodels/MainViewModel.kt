package com.yoesuv.multiplerequest.menu.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.yoesuv.multiplerequest.networks.ApplicationResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    private val appResponse = ApplicationResponse()

    fun getData() {

    }

    fun getListPlace(){
        compositeDisposable.add(
            appResponse.getListPlace()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({},{})
        )
    }

    fun getListGallery(){
        compositeDisposable.add(
            appResponse.getListGallery()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({},{})
        )
    }
}