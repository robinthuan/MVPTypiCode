package com.example.mvptypicode.networking

import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.model.PostListResponse
import retrofit2.http.GET
import rx.Observable

interface NetworkService {
    @get :GET("posts")
    val postList: Observable<List<PostData>>

}