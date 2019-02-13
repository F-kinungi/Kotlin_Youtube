package com.francis.kotlin_youtube

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_rows.view.*


class CustomAdapter(private val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
val view = LayoutInflater.from(p0.context).inflate(R.layout.video_rows, p0, false)
        return CustomViewHolder(view)
    }
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }
    override fun onBindViewHolder(holder: CustomViewHolder, p1: Int) {
        val videos = homeFeed.videos[p1]
        holder.itemView.textView_video_Title.text = videos.name
        holder.itemView.textView_Channel_Name.text = videos.channel.name+ " * "+ "20k Views\n4 days ago"

        val thumbNailImageView = holder.itemView.imageView_video_ThumbNail
        Picasso.get().load(videos.imageUrl).into(thumbNailImageView)
        val channelProfileImage = holder.itemView.imageView_profile
        Picasso.get().load(videos.channel.profileImageUrl).into(channelProfileImage)

        holder.video = videos

    }
}
class CustomViewHolder(itemView:View, var video:Video? = null):RecyclerView.ViewHolder(itemView) {

    companion object {
        val VIDEO_KEY_TITLE = "VIDEO TITLE"
        val VIDEO_ID_KEY= "VIDEO ID"
    }
    init {
        itemView.setOnClickListener {

            val intent = Intent(itemView.context, CourseDetailActivity::class.java)
            intent.putExtra(VIDEO_KEY_TITLE, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)
            itemView.context.startActivity(intent)

        }
    }

}

//CustomViewHolder is used to cache view objects inorder to safe memory

//The adapter(CustomAdapter) create new items inform of viewHolder, populate the viewHolders with data
// and return information about the data


//LinearLayoutManger. Layout manager is used to position views
//inside the RecyclerView.They also determine when to reuse items
//that are no longer visible to the user

//onCreateViewHolder, is used to inflate the custom layout view that we will be used to hold each list item

//onBindViewHolder is used to bind the list items to views(textview, edittextview, imageView)