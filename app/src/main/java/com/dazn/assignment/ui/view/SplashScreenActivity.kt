package com.dazn.assignment.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.dazn.assignment.R
import com.dazn.assignment.databinding.ActivitySplashScreenBinding
import kotlin.random.Random


class SplashScreenActivity : AppCompatActivity(), OnPlayerClickInterface {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var adapter: TicTacGridAdapter
    private lateinit var list: ArrayList<ItemViewModel>
    private val x = "X"
    private val o = "O"

    companion object{
        var isClickable = true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val manager = GridLayoutManager(this, 3)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        resetGame()
        binding.apply {
            ticTacRV.layoutManager = manager
            ticTacRV.adapter = adapter
        }
        binding.ticTacRV.layoutManager = manager
        binding.resetGameBtn.setOnClickListener {
            resetGame()
        }

    }

    private fun resetGame() {
        list = ArrayList()
        for (i in 0..8) {
            list.add(ItemViewModel("-"))
        }
        adapter = TicTacGridAdapter(list, this)
        binding.ticTacRV.adapter = adapter
        isClickable = true
    }

    override fun playerClick(item: ItemViewModel, holder: TicTacGridAdapter.ViewHolder) {
        val freeColumnList = ArrayList<Int>()
        if (item.value == "-") {
            holder.ticTacTV.text = x
            item.value = x
        }
        for (i in 0 until list.size)
            if (list[i].value == "-") {
                freeColumnList.add(i)
            }
        if (freeColumnList.size > 0) {
            val pos = getRandomPos(freeColumnList)
            list[pos].value = "O"
            adapter.notifyItemChanged(pos)
            checkWinner(list)
            Log.i("90900", "onBindViewHolder: $list")
        }
    }

    private fun checkWinner(
        ticTacList: ArrayList<ItemViewModel>
    ) {
        ticTacList.let {
            if ((it[0].value == it[1].value) && (it[0].value == it[2].value))
                printWinner(it[0].value)
            if ((it[3].value == it[4].value) && (it[3].value == it[5].value))
                printWinner(it[3].value)
            if ((it[6].value == it[7].value) && (it[6].value == it[8].value))
                printWinner(it[6].value)

            if ((it[0].value == it[3].value) && (it[0].value == it[6].value))
                printWinner(it[0].value)
            if ((it[1].value == it[4].value) && (it[1].value == it[7].value))
                printWinner(it[1].value)
            if ((it[2].value == it[5].value) && (it[2].value == it[8].value))
                printWinner(it[2].value)

            if ((it[0].value == it[4].value) && (it[0].value == it[8].value))
                printWinner(it[0].value)
            if ((it[2].value == it[4].value) && (it[2].value == it[6].value))
                printWinner(it[6].value)
        }

    }

    private fun printWinner(value: String) {
        if (value == x || value == o) {
            binding.winnerTV.text = value.plus(" is winner!!")
            isClickable = false
        }
    }

    private fun getRandomPos(list: ArrayList<Int>): Int {
        val randomIndex = Random.nextInt(list.size)
        val randomNumber = list[randomIndex]
        println("Random number: $randomNumber")
        return randomNumber
    }
}