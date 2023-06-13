package com.dazn.assignment.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dazn.assignment.R


class SplashScreenActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this@SplashScreenActivity, ImageListActivity::class.java)
                startActivity(intent)
                finish()
            }, splashTimeOut)
        }
    }
}