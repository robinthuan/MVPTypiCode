package com.example.mvptypicode.view.gallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvptypicode.R
import com.example.mvptypicode.model.PostData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_gallery.view.*

class GalleryAdapter(private val list: List<PostData>) :
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        Picasso.get().load(Uri.parse(list[position].thumbnailUrl)).into(holder.image)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title!!
        val image = view.image!!
    }
}