package com.example.mvptypicode.callback

import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.networking.NetworkError

interface GetListGalleryCallBack {
    fun getListGallerySuccess(list: List<PostData>)
    fun getListGalleryFailure(networkError: NetworkError)
}