package com.dazn.assignment.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.dazn.assignment.R
import com.dazn.assignment.databinding.ActivitySplashScreenBinding
import kotlin.random.Random


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var adapter:TicTacGridAdapter
    private val splashTimeOut: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val manager = GridLayoutManager(this, 3)
        resetGame()
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        binding.apply {
            ticTacRV.layoutManager = manager
            ticTacRV.adapter = adapter
        }
        getRandomPos()
        binding.ticTacRV.layoutManager = manager

        binding.resetGameBtn.setOnClickListener {
            resetGame()
            adapter.notifyDataSetChanged()
        }
    }

    private fun resetGame() {
        val list = ArrayList<ItemViewModel>()
        for (i in 0..8) {
            list.add(ItemViewModel("-"))
        }
        adapter = TicTacGridAdapter(list)
    }

    private fun getRandomPos(){
        val randomNum = List(1){ Random.nextInt(0,8)}
        Log.i("12990", "getRandomPos: $randomNum")
    }
}