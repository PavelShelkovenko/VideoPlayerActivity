package com.example.videoplayeractivity.domain

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.videoplayeractivity.R


data class VideoItem(
    val name: String = UNDEFINED_NAME,
    var id: Int = UNDEFINED_ID,
    var imagePreview: Bitmap
) {
    companion object {
        const val UNDEFINED_ID = -1
        const val UNDEFINED_NAME = "NAME_NOT_DEFINED"
    }
}
