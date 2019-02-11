package com.francis.kotlin_youtube

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CourseDetailAdapter:RecyclerView.Adapter<CourseDetailAdapter.CustomLessonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomLessonViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_lesson_row,parent, false)
        return CustomLessonViewHolder(view)

    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: CustomLessonViewHolder, p1: Int) {
    }

    inner class CustomLessonViewHolder(customView:View):RecyclerView.ViewHolder(customView) {


    }
}