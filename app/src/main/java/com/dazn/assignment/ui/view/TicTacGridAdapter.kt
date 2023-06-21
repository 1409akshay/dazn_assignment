package com.dazn.assignment.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dazn.assignment.R

class TicTacGridAdapter(
    private val ticTacList: ArrayList<ItemViewModel>,
    private val onPlayerClickInterface: OnPlayerClickInterface
) :
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
        holder.ticTacTV.text = item.value

        holder.ticTacTV.setOnClickListener {
            if (holder.ticTacTV.text == "-" && SplashScreenActivity.isClickable) {
                onPlayerClickInterface.playerClick(item, holder)
            }
        }
    }


    override fun getItemCount() = ticTacList.size

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val ticTacTV: TextView = itemview.findViewById(R.id.ticTacItemTV)
    }

}

