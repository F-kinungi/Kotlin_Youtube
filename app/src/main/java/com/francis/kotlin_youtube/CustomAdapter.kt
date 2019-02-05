package com.francis.kotlin_youtube

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.video_rows.view.*


class CustomAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
val view = LayoutInflater.from(p0.context).inflate(R.layout.video_rows, p0, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }
    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val videos = homeFeed.videos[p1]
        holder.itemView.textView_video_Title.text = videos.name
        holder.itemView.textView_Channel_Name.text = videos.channel.name

    }
}
class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

}
