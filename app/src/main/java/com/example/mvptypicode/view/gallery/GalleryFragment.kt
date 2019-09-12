package com.example.mvptypicode.view.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvptypicode.BaseFragment
import com.example.mvptypicode.R
import com.example.mvptypicode.model.PostData
import com.example.mvptypicode.utils.ConstantText
import kotlinx.android.synthetic.main.frag_gallery.*
import kotlinx.android.synthetic.main.progressbar_layout.*

class GalleryFragment : BaseFragment(), GalleryView {
    override fun visibleWaiting() {
        progressWaiting.visibility = View.VISIBLE
    }

    override fun disableWaiting() {
        progressWaiting.visibility = View.GONE
    }

    override fun getListGallerySuccess(list: List<PostData>) {
        showToast(ConstantText.SUCCESS, "get list gallery successful !!", context!!)
        disableWaiting()
        initData(list)
    }

    override fun getListGalleryFailure(error: String) {
        disableWaiting()
        showToast(ConstantText.ERROR, error, context!!)
    }

    private fun initData(list: List<PostData>) {
        listGallery.addAll(list)
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_gallery, container, false)
    }

    lateinit var galleryPresenter: GalleryPresenter
    lateinit var adapter: GalleryAdapter
    lateinit var listGallery: ArrayList<PostData>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        getNetworkComponent().inject(this)
        listGallery = ArrayList()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = GalleryAdapter(listGallery)
        recyclerListGallery.layoutManager = layoutManager
        recyclerListGallery.adapter = adapter
        galleryPresenter = GalleryPresenter(apiService, this)
        galleryPresenter.getListGallery()

    }
}