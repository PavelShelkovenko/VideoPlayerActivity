package com.example.videoplayeractivity.domain

import android.net.Uri

interface VideoListRepository {

    fun getVideoPath(videoItem: VideoItem): String

    fun getVideoUri(videoItem: VideoItem): Uri

    fun getVideoName(videoItem: VideoItem): String

    fun addVideoItem(videoItem: VideoItem)

    fun getVideoListItem(videoItemId: Int): VideoItem

}