package com.example.dateconversion.utils

import android.text.format.DateUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("elapsedTime")
fun TextView.setElapsedTime(value : Long){
    val seconds = value / 1000
    text = if (seconds < 60) seconds.toString() else DateUtils.formatElapsedTime(seconds)
}