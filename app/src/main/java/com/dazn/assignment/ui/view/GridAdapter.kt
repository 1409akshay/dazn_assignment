package com.dazn.assignment.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dazn.assignment.viewmodel.ImageViewModel
import com.dazn.assignment.databinding.GridItemLayoutBinding
import com.dazn.assignment.data.model.ImgItem

class GridAdapter(
    private val items: List<ImgItem>,
    private val clickInterface: ClickInterface,
    private val imageViewModel: ImageViewModel
) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {
    private lateinit var binding: GridItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = GridItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position], position)

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(imageResource: ImgItem, position: Int) {
            imageViewModel.loadImageIntoImageView(imageResource.link , binding.albumImage)
            binding.albumImage.setOnClickListener {
                clickInterface.onImageClickListener(imageResource, position)
            }
        }
    }
}