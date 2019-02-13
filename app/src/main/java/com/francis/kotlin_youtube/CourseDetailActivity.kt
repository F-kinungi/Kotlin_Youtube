package com.francis.kotlin_youtube


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class CourseDetailActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)


        val navBarTitle = intent.getStringExtra(CustomViewHolder.VIDEO_KEY_TITLE)
        supportActionBar?.title = navBarTitle

     fetchJson2()

    }
    private fun fetchJson2() {
        val videoId = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY, -1)//provide default value if you do'nt have something available
        val courseDetailUrl = "https://api.letsbuildthatapp.com/youtube/course_detail?id= $videoId"

         val client = OkHttpClient()
        val request = Request.Builder().url(courseDetailUrl).build()
        client.newCall(request).enqueue(object : Callback{

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()!!.string()
                val gson = GsonBuilder().create()
                val courseLessons = gson.fromJson(body, Array<CourseLesson>::class.java)

                runOnUiThread {
                    recyclerView.adapter = CourseDetailAdapter(courseLessons)
                }
            }
            override fun onFailure(call: Call, e: IOException) {

            }

        })
    }
}