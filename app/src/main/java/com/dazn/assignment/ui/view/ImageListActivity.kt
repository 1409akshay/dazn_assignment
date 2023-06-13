package com.dazn.assignment.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dazn.assignment.viewmodel.ImageViewModel
import com.dazn.assignment.R
import com.dazn.assignment.databinding.ActivityImageListBinding
import com.dazn.assignment.databinding.ImageDetailSheetBinding
import com.dazn.assignment.data.model.ImgItem
import com.google.android.material.bottomsheet.BottomSheetDialog

class ImageListActivity : AppCompatActivity(), ClickInterface {
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var binding: ActivityImageListBinding
    private lateinit var imageViewModel: ImageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this@ImageListActivity, R.layout.activity_image_list)
        imageViewModel = ViewModelProvider(this@ImageListActivity).get(ImageViewModel::class.java)
        val imageList = imageViewModel.getImageList()
        binding.apply {
            imageRecycler.layoutManager = GridLayoutManager(this@ImageListActivity, 2)
            imageRecycler.adapter = GridAdapter(imageList, this@ImageListActivity, imageViewModel)
        }
    }

    override fun onImageClickListener(imgItem: ImgItem, pos: Int) = showBottomSheet(imgItem)

    private fun showBottomSheet(imgItemRes: ImgItem) {
        val binding: ImageDetailSheetBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this@ImageListActivity),
            R.layout.image_detail_sheet,
            null,
            false
        )
        bottomSheetDialog =
            BottomSheetDialog(this@ImageListActivity, R.style.BottomSheetDialogCustom)
        bottomSheetDialog.setContentView(binding.root)
        binding.apply {
            imgItemRes.apply {
                imgName.text = getString(R.string.namestr, name)
                imgDimension.text = getString(R.string.img_resoultion, resolution)
                imgDetail.text = getString(R.string.detail, details)
                imageViewModel.loadImageIntoImageView(link, icon)
            }
        }
        bottomSheetDialog.show()
    }
}