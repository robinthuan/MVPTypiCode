package com.example.mvptypicode.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mvptypicode.R
import com.example.mvptypicode.model.PostData
import kotlinx.android.synthetic.main.item_recyler_list_post.view.*

class HomeAdapter(private val listPost: List<PostData>, val homeView: HomeView) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recyler_list_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPost.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = listPost[position].title
        holder.content.text = listPost[position].body
        holder.itemPost.setOnClickListener {
            homeView.detailItemPost(listPost[position].id!!)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title!!
        val content = view.content!!
        val itemPost = view.itemPostContainer!!
    }
}