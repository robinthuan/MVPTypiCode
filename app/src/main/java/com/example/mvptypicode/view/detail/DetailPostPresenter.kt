package com.example.mvptypicode.view.detail

import com.example.mvptypicode.callback.GetPostDetailCallBack
import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.networking.ApiService
import com.example.mvptypicode.networking.NetworkError
import rx.subscriptions.CompositeSubscription

class DetailPostPresenter(
    private val apiService: ApiService,
    private val detailPostView: DetailPostView
) {
    private val subscriptions = CompositeSubscription()
    fun getDetailPost(id: Int) {
        detailPostView.visibleWaiting()
        val subscription = apiService.getPostDetail(id, object : GetPostDetailCallBack {
            override fun getPostDetailSuccess(postData: PostData) {
                detailPostView.getPostDetailSuccess(postData)
            }

            override fun getPostDetailFailure(networkError: NetworkError) {
                detailPostView.getPostDetailFailure(networkError.getMessage())
            }

        })
        subscriptions.add(subscription)
    }
}