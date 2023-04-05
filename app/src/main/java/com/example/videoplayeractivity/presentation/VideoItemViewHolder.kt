package com.example.videoplayeractivity.presentation

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplayeractivity.R

class VideoItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val videoImagePreview: ImageView = view.findViewById(R.id.video_preview_image)
}