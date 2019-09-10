package com.example.mvptypicode.view.home

import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.model.PostListResponse

interface HomeView {
    fun getListPostSuccess(listResponse: List<PostData>)
    fun getListPostFailure(error: String)
}