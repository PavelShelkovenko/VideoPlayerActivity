package com.example.videoplayeractivity.presentation


import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.videoplayeractivity.R
import com.example.videoplayeractivity.data.VideoListRepositoryImpl
import com.example.videoplayeractivity.domain.VideoItem
import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var videoListAdapter: VideoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val camel: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.camel)
        val regina: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.regina)

        val fireworks: LottieAnimationView = findViewById(R.id.fireworks)
        val gift: LottieAnimationView = findViewById(R.id.gift)

        val rvVideoList = findViewById<RecyclerView>(R.id.rv_video_list)
        rvVideoList.isGone = true
        setVideoList()

        gift.setOnClickListener {
            fireworks.playAnimation()
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    gift.isGone = true
                    fireworks.isGone = true
                    rvVideoList.isGone = false
                },
                1300
            )
        }

        videoListAdapter = VideoListAdapter()
        rvVideoList?.adapter = videoListAdapter
        videoListAdapter.submitList((VideoListRepositoryImpl.videoItemList).toList())

        videoListAdapter.onShopItemClickListener = {

            val intent = VideoItemActivity.newIntentVideoItemActivity(this, it)
            startActivity(intent)

            when (it.name) {
                "regina" -> VideoListRepositoryImpl.videoItemList[it.id].imagePreview = regina
                "camel" -> VideoListRepositoryImpl.videoItemList[it.id].imagePreview = camel
                else -> throw RuntimeException("Invalid ${it.name}")
            }
            videoListAdapter.notifyItemChanged(it.id)
        }


    }

    private fun setVideoList() {

        val questionMark: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.question_mark)

        VideoListRepositoryImpl.addVideoItem(VideoItem("example",0, questionMark))
        VideoListRepositoryImpl.addVideoItem(VideoItem("regina",1, questionMark))
        VideoListRepositoryImpl.addVideoItem(VideoItem("camel",2, questionMark))
    }
}