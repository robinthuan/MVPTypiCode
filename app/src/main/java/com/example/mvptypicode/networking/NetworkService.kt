package com.example.mvptypicode.networking

import com.example.mvptypicode.model.PostData
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface NetworkService {
    @get :GET("posts")
    val postList: Observable<List<PostData>>

    @GET("posts/{id}")
    fun detailPost(@Path("id") id: Int): Observable<PostData>

    @get :GET("photos")
    val galleryList: Observable<List<PostData>>

}