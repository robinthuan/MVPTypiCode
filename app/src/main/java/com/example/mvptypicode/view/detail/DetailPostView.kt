package com.example.mvptypicode.view.detail

import com.example.mvptypicode.model.PostData

interface DetailPostView {
    fun visibleWaiting()
    fun disableWaiting()
    fun getPostDetailSuccess(postData: PostData)
    fun getPostDetailFailure(error: String)
}