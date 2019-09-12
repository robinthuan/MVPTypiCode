package com.example.mvptypicode.view.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvptypicode.BaseFragment
import com.example.mvptypicode.R
import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.utils.ConstantText
import com.example.mvptypicode.utils.MessageEvent
import kotlinx.android.synthetic.main.frag_detail_post.*
import kotlinx.android.synthetic.main.progressbar_layout.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class DetailPostFragment : BaseFragment(), DetailPostView {
    override fun visibleWaiting() {
        progressWaiting.visibility = View.VISIBLE
    }

    override fun disableWaiting() {
        progressWaiting.visibility = View.GONE
    }

    override fun getPostDetailSuccess(postData: PostData) {
        disableWaiting()
        showToast(ConstantText.SUCCESS, "get detail post successful !!", context!!)
        initData(postData)

    }

    override fun getPostDetailFailure(error: String) {
        disableWaiting()
        showToast(ConstantText.ERROR, error, context!!)
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_detail_post, container, false)
    }

    var idPost = 0
    lateinit var detailPostPresenter: DetailPostPresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun initData(postData: PostData) {
        userId?.text = postData.userId.toString()
        postId?.text = postData.id.toString()
        title?.text = postData.title.toString()
        body?.text = postData.body.toString()

    }

    private fun init() {
        getNetworkComponent().inject(this)
        detailPostPresenter = DetailPostPresenter(apiService, this)

    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: MessageEvent) {
        Log.d("POST_ID", "init :${messageEvent.id}")
        detailPostPresenter.getDetailPost(messageEvent.id)
    }
}