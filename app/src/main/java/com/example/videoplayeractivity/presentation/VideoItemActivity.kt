package com.example.videoplayeractivity.presentation

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import com.example.videoplayeractivity.R
import com.example.videoplayeractivity.data.VideoListRepositoryImpl
import com.example.videoplayeractivity.domain.VideoItem

class VideoItemActivity : AppCompatActivity() {

    private var videoItemId: Int? = null
    private var videoItemName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_item)

        val arguments = intent.extras


        if (arguments != null) {
            videoItemName = arguments.getString(VIDEO_NAME)
            videoItemId = arguments.getInt(VIDEO_ID)
        }


        val videoView: VideoView = findViewById(R.id.video_view)
        val videoItem = videoItemId?.let { VideoListRepositoryImpl.getVideoListItem(it) }
        val videoItemUri = videoItem?.let { VideoListRepositoryImpl.getVideoUri(it) }
        videoView.setVideoURI(videoItemUri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

        videoView.start()
    }

    companion object {

        private const val VIDEO_ID = "extra_video_id"
        private const val VIDEO_NAME = "extra_video_name"

        fun newIntentVideoItemActivity(context: Context, videoItem: VideoItem): Intent {
            val intent = Intent(context, VideoItemActivity::class.java)
            intent.putExtra(VIDEO_NAME, videoItem.name)
            intent.putExtra(VIDEO_ID, videoItem.id)
            return intent
        }
    }
}

