package com.dazn.assignment.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

object PicassoImageUploader {
    fun imageUploader(url: String, imgView: ImageView) {
        Picasso.get().load(url).into(imgView)
    }
}