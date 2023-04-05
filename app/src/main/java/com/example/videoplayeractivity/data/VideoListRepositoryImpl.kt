package com.example.videoplayeractivity.data

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import com.example.videoplayeractivity.R
import com.example.videoplayeractivity.domain.VideoItem
import com.example.videoplayeractivity.domain.VideoListRepository

object VideoListRepositoryImpl: VideoListRepository {

    var videoItemList = mutableListOf<VideoItem>()

    override fun getVideoPath(videoItem: VideoItem): String {
        return "android.resource://com.example.videoplayeractivity/raw/${videoItem.name}"
    }

    override fun getVideoUri(videoItem: VideoItem): Uri {
        return Uri.parse(getVideoPath(videoItem))
    }

    override fun getVideoName(videoItem: VideoItem): String {
        return videoItem.name
    }

    override fun addVideoItem(videoItem: VideoItem) {
        if(videoItem.id == VideoItem.UNDEFINED_ID) {
            return
        }
        if (videoItem.id < videoItemList.size) {
            return
        }
        videoItemList.add(videoItem)
    }

    override fun getVideoListItem(videoItemId: Int): VideoItem {
        return videoItemList[videoItemId]
    }

}