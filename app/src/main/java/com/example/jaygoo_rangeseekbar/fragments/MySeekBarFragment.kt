package com.example.jaygoo_rangeseekbar.fragments

import android.view.View
import com.example.jaygoo_rangeseekbar.R
import com.jaygoo.widget.RangeSeekBar

class MySeekBarFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_my

    override fun initView(view: View) {
        val seekRate = view.findViewById<RangeSeekBar>(R.id.seekRate)
        val rate = 15.0
        val steps = seekRate.steps
        val stepRate = 100.0 / steps
        var progress = (rate / stepRate * 100.0).toFloat()

        seekRate.setProgress(progress)
    }
}