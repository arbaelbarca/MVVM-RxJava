package com.arbaelbarca.grawgames.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.arbaelbarca.grawgames.R
import com.arbaelbarca.grawgames.data.base.BaseActivityBinding
import com.arbaelbarca.grawgames.databinding.ActivityFrameLayoutBinding
import com.arbaelbarca.grawgames.ui.view.fragment.home.HomeFragment

class FrameLayoutActivity : BaseActivityBinding<ActivityFrameLayoutBinding>() {
    lateinit var frameLayoutBinding: ActivityFrameLayoutBinding
    override val bindingInflater: (LayoutInflater) -> ActivityFrameLayoutBinding
        get() = ActivityFrameLayoutBinding::inflate

    override fun setupView(binding: ActivityFrameLayoutBinding) {
        frameLayoutBinding = binding
        initial()
    }

    private fun initial() {
        setFragment(HomeFragment())
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

}