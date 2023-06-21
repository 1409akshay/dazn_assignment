package com.dazn.assignment.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dazn.assignment.R

class TicTacGridAdapter(val ticTacList: ArrayList<ItemViewModel>) :
    RecyclerView.Adapter<TicTacGridAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tic_tac_column, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ticTacList[position]
        if (item.value == "X" || item.value == "O") {

        }
    }

    override fun getItemCount() = ticTacList.size

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val ticTacIV = itemview.findViewById<TextView>(R.id.ticTacItemTV)
    }
}

