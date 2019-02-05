package com.francis.kotlin_youtube

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //recyclerView.setBackgroundColor(Color.BLUE)

        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = CustomAdapter()

        fetchJson()
    }

    private fun fetchJson() {
        println("Attempting to fetch json file ")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()!!.string()
                println(body)
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson<HomeFeed>(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerView.adapter = CustomAdapter(homeFeed)
                }

            }
            override fun onFailure(call: Call, e: IOException) {
                println("failed to execute request")
            }

        })
    }
}
