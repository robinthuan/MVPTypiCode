package com.example.mvptypicode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.networking.ApiService
import com.example.mvptypicode.view.home.HomePresenter
import com.example.mvptypicode.view.home.HomeView
import kotlinx.android.synthetic.main.frag_post.*
import javax.inject.Inject

class FragmentPost : BaseFragment(), HomeView {
    val TAG = "TEST_MVP"
    override fun getListPostSuccess(listResponse: List<PostData>) {
        Log.d(TAG, "${listResponse.size}")
    }

    override fun getListPostFailure(error: String) {
    }

    @Inject
    lateinit var apiService: ApiService
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getNetworkComponent().inject(this)
        homePresenter = HomePresenter(apiService, this)
        getPost.setOnClickListener {
            homePresenter.getListPost()
        }
    }
}