package com.example.mvptypicode.view.gallery

import com.example.mvptypicode.callback.GetListGalleryCallBack
import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.networking.ApiService
import com.example.mvptypicode.networking.NetworkError
import rx.subscriptions.CompositeSubscription

class GalleryPresenter(private val apiService: ApiService, private val galleryView: GalleryView) {
    private val subscriptions = CompositeSubscription()
    fun getListGallery() {
        galleryView.visibleWaiting()
        val subscription = apiService.getListGallery(object : GetListGalleryCallBack {
            override fun getListGallerySuccess(list: List<PostData>) {
                galleryView.getListGallerySuccess(list)
            }

            override fun getListGalleryFailure(networkError: NetworkError) {
                galleryView.getListGalleryFailure(networkError.getMessage())
            }
        })
        subscriptions.add(subscription)
    }
}