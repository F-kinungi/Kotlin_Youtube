package com.francis.kotlin_youtube

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CourseDetailAdapter(private val courseLessons: Array<CourseLesson>):RecyclerView.Adapter<CourseDetailAdapter.CustomLessonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomLessonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_lesson_row,parent, false)
        return CustomLessonViewHolder(view)
    }
    override fun getItemCount(): Int {
        return courseLessons.size
    }
    override fun onBindViewHolder(holder: CustomLessonViewHolder, p1: Int) {

    }
    class CustomLessonViewHolder(customView:View):RecyclerView.ViewHolder(customView) {
    init {
        customView.setOnClickListener {
           // println("Attempt to load webview Somehow")
            val intent = Intent(customView.context, CourseLessonActivity::class.java)
            customView.context.startActivity(intent)

        }
    }
    }
}
