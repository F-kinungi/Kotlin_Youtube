package com.francis.kotlin_youtube

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course_lesson.*

class CourseLessonActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_lesson)

        //webView_Course_Lesson.setBackgroundColor(Color.BLUE)

        webView_Course_Lesson.loadUrl("https:www.google.com")
        //webView_Course_Lesson.loadUrl("https://www.lodemann.dk")
    }
}