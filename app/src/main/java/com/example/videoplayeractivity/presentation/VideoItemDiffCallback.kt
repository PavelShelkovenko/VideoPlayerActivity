package com.example.videoplayeractivity.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.videoplayeractivity.domain.VideoItem

class VideoItemDiffCallback: DiffUtil.ItemCallback<VideoItem>() {
    override fun areItemsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean {
        return oldItem == newItem
    }
}