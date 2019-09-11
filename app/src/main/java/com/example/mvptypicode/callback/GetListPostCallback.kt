package com.example.mvptypicode.callback

import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.networking.NetworkError

interface GetListPostCallback {
    fun getListPostSuccess(listResponse: List<PostData>)
    fun getListPostFailure(networkError: NetworkError)
}