package com.example.mvptypicode.networking

import com.example.mvptypicode.model.PostData
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiService(val network: NetworkService) {
    interface getListPostCallback {
        fun getListPostSuccess(listResponse: List<PostData>)
        fun getListPostFailure(networkError: NetworkError)
    }

    fun getListPost(callback: getListPostCallback): Subscription {
        return network.postList
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<List<PostData>>() {
                override fun onNext(t: List<PostData>?) {
                    callback.getListPostSuccess(t!!)
                }

                override fun onCompleted() {
                }

                override fun onError(e: Throwable?) {
                    callback.getListPostFailure(NetworkError(e))
                }
            })
    }
}