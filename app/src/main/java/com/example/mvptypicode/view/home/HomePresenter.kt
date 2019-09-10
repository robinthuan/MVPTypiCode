package com.example.mvptypicode.view.home

import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.model.PostListResponse
import com.example.mvptypicode.networking.ApiService
import com.example.mvptypicode.networking.NetworkError
import rx.subscriptions.CompositeSubscription

class HomePresenter(val apiService: ApiService, val homeView: HomeView) {
    var subscriptions = CompositeSubscription()
    fun getListPost() {
        val subscription = apiService.getListPost(object : ApiService.getListPostCallback {
            override fun getListPostSuccess(listResponse: List<PostData>) {
                homeView.getListPostSuccess(listResponse)
            }

            override fun getListPostFailure(networkError: NetworkError) {
                homeView.getListPostFailure(networkError.getMessage())
            }

        })
        subscriptions.add(subscription)
    }
}