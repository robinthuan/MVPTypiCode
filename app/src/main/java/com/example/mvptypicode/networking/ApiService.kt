package com.example.mvptypicode.networking

import com.example.mvptypicode.callback.GetListPostCallback
import com.example.mvptypicode.callback.GetPostDetailCallBack
import com.example.mvptypicode.model.PostData
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiService(private val network: NetworkService) {


    fun getListPost(callback: GetListPostCallback): Subscription {
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

    fun getPostDetail(postId: Int, callBack: GetPostDetailCallBack): Subscription {
        return network.detailPost(postId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<PostData>() {
                override fun onNext(t: PostData?) {
                    callBack.getPostDetailSuccess(t!!)
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {
                    callBack.getPostDetailFailura(NetworkError(e))
                }

            })

    }
}