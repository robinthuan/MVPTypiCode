package com.example.mvptypicode.callback

import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.networking.NetworkError

interface GetPostDetailCallBack {
    fun getPostDetailSuccess(postData: PostData)
    fun getPostDetailFailura(networkError: NetworkError)
}