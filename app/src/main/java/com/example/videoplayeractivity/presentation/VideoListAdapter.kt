package com.example.videoplayeractivity.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.videoplayeractivity.R
import com.example.videoplayeractivity.domain.VideoItem

class VideoListAdapter: ListAdapter<VideoItem, VideoItemViewHolder>(VideoItemDiffCallback()) {

    var onShopItemClickListener: ((VideoItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return VideoItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoItemViewHolder, position: Int) {
        val videoItem = getItem(position)
        holder.videoImagePreview.setImageBitmap(videoItem.imagePreview)
        holder.view.setOnClickListener {
            onShopItemClickListener?.invoke(videoItem)
        }
    }


}