package com.example.mvptypicode.view.home

import com.example.mvptypicode.model.PostData

interface HomeView {
    fun getListPostSuccess(listResponse: List<PostData>)
    fun getListPostFailure(error: String)
    fun visibleWaiting()
    fun disableWaiting()
    fun detailItemPost(position: Int)
}