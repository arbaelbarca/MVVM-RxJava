package com.arbaelbarca.grawgames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arbaelbarca.grawgames.ui.view.activity.FrameLayoutActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, FrameLayoutActivity::class.java))
        finish()
    }
}