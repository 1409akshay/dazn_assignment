package com.dazn.assignment.ui.view

import com.dazn.assignment.data.model.ImgItem

interface ClickInterface {
    fun onImageClickListener(imgItem: ImgItem, pos:Int)
}