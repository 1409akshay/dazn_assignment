package com.dazn.assignment.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import com.dazn.assignment.utils.PicassoImageUploader
import com.dazn.assignment.data.model.ImageJson
import com.dazn.assignment.data.model.ImgItem
import com.google.gson.Gson

class ImageViewModel(application: Application) : AndroidViewModel(application) {
    private val imageList: List<ImgItem>
    private val FILE_NAME = "imagelist.json"

    init {
        val json: String = application.assets.open(FILE_NAME).bufferedReader().use { it.readText() }
        val imgJson = Gson().fromJson(json, ImageJson::class.java)
        imageList = imgJson.img_list
    }

    fun getImageList(): List<ImgItem> {
        return imageList
    }

    fun loadImageIntoImageView(imageUrl: String, imageView: ImageView) {
        PicassoImageUploader.imageUploader(imageUrl, imageView)
    }
}