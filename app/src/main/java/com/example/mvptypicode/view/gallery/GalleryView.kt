package com.example.mvptypicode.view.gallery

import com.example.mvptypicode.model.PostData

interface GalleryView {
    fun visibleWaiting()
    fun disableWaiting()
    fun getListGallerySuccess(list: List<PostData>)
    fun getListGalleryFailure(error: String)

}