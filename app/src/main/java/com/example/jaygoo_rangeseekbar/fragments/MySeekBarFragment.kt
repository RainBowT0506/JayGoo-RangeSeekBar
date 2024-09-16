package com.example.jaygoo_rangeseekbar.fragments

import android.view.View
import com.example.jaygoo_rangeseekbar.R
import com.jaygoo.widget.RangeSeekBar

class MySeekBarFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.fragment_my

    override fun initView(view: View) {
        val seekRate = view.findViewById<RangeSeekBar>(R.id.seekRate)
        val rate = (25.0).toInt()
        seekRate.setRange(0f, 100f)
        val steps = seekRate.steps

        println("Steps: ${seekRate.steps}")
        println("最小間隔: ${seekRate.minInterval}")

        val progress = getReferralProgress(rate,steps)
        val minProgress = seekRate.minProgress
        val maxProgress = seekRate.maxProgress
        println("最小值: $minProgress, 最大值: $maxProgress")
        seekRate.setProgress(100.0F)
        println("當前進度: ${seekRate.leftSeekBar.progress}")
    }

    fun getReferralProgress(rate: Int, steps: Int): Float {
        val stepRate = 100.0 / steps
        val progress = when (rate) {
            10 -> stepRate
            15 -> stepRate * 2
            20 -> stepRate * 3
            25 -> stepRate * 4
            else -> 0f
        }
        return progress.toFloat()
    }
}