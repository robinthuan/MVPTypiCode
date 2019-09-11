package com.example.mvptypicode.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvptypicode.BaseFragment
import com.example.mvptypicode.R
import com.example.mvptypicode.Utils.ConstantText
import com.example.mvptypicode.model.PostData
import kotlinx.android.synthetic.main.frag_home.*
import kotlinx.android.synthetic.main.progressbar_layout.*
import org.greenrobot.eventbus.EventBus

class HomeFragment : BaseFragment(), HomeView {
    override fun detailItemPost(position: Int) {
     EventBus.builder().sendSubscriberExceptionEvent()
    }

    override fun visibleWaiting() {
        progressWaiting.visibility = View.VISIBLE
    }

    override fun disableWaiting() {
        progressWaiting.visibility = View.GONE
    }

    val TAG = "TEST_MVP"
    override fun getListPostSuccess(listResponse: List<PostData>) {
        disableWaiting()
        showToast(ConstantText.SUCCESS, "get list post success !", context!!)
        listPost.addAll(listResponse)
        adapter.notifyDataSetChanged()
    }

    override fun getListPostFailure(error: String) {
        disableWaiting()
        showToast(ConstantText.ERROR, error, context!!)
    }


    lateinit var homePresenter: HomePresenter
    lateinit var adapter: HomeAdapter
    lateinit var listPost: ArrayList<PostData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        listPost = ArrayList()
        adapter = HomeAdapter(listPost, this)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerListPost.layoutManager = layoutManager
        recyclerListPost.adapter = adapter
        getNetworkComponent().inject(this)
        homePresenter = HomePresenter(apiService, this)
        homePresenter.getListPost()
    }
}