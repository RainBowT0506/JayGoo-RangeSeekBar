package com.example.jaygoo_rangeseekbar.fragments

import android.view.View
import com.example.jaygoo_rangeseekbar.R
import com.jaygoo.widget.OnRangeChangedListener
import com.jaygoo.widget.RangeSeekBar
import com.jaygoo.widget.SeekBar

class RangeSeekBarFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_range
    }

    override fun initView(view: View) {
        val sbRange1 = view.findViewById<RangeSeekBar>(R.id.sb_range_1)
        val sbRange2 = view.findViewById<RangeSeekBar>(R.id.sb_range_2)
        val sbRange3 = view.findViewById<RangeSeekBar>(R.id.sb_range_3)
        val sbRange4 = view.findViewById<RangeSeekBar>(R.id.sb_range_4)
        val sbRange5 = view.findViewById<RangeSeekBar>(R.id.sb_range_5)
        val sbRange6 = view.findViewById<RangeSeekBar>(R.id.sb_range_6)
        val sbRange8 = view.findViewById<RangeSeekBar>(R.id.sb_range_8)

        sbRange1?.setProgress(0f, 100f)
        changeSeekBarThumb(sbRange1.leftSeekBar, sbRange1.leftSeekBar.progress)
        changeSeekBarThumb(sbRange1.rightSeekBar, sbRange1.rightSeekBar.progress)
        sbRange1?.setOnRangeChangedListener(object : OnRangeChangedListener {
            override fun onRangeChanged(
                rangeSeekBar: RangeSeekBar,
                leftValue: Float,
                rightValue: Float,
                isFromUser: Boolean
            ) {
                changeSeekBarThumb(rangeSeekBar.leftSeekBar, leftValue)
                changeSeekBarThumb(rangeSeekBar.rightSeekBar, rightValue)
            }

            override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {
                // Handle start tracking
            }

            override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {
                // Handle stop tracking
            }
        })

        sbRange2?.setProgress(0f, 100f)
        sbRange3?.setRange(-100f, 100f)
        sbRange3?.setProgress(0f, 80f)
        sbRange3?.setIndicatorTextDecimalFormat("0")
        sbRange4?.setProgress(20f, 70f)
        sbRange5?.setProgress(20f, 60f)
        sbRange6?.setProgress(20f, 70f)
        sbRange8?.setProgress(20f, 60f)
        sbRange8?.leftSeekBar?.thumbDrawableId = R.drawable.step_1
        sbRange8?.rightSeekBar?.thumbDrawableId = R.drawable.step_2
    }

    private fun changeSeekBarThumb(seekbar: SeekBar, value: Float) {
        if (value < 33) {
            seekbar.setThumbDrawableId(
                R.drawable.thumb_green,
                seekbar.thumbWidth,
                seekbar.thumbHeight
            )
        } else if (value < 66) {
            seekbar.setThumbDrawableId(
                R.drawable.thumb_yellow,
                seekbar.thumbWidth,
                seekbar.thumbHeight
            )
        } else {
            seekbar.setThumbDrawableId(
                R.drawable.thumb_red,
                seekbar.thumbWidth,
                seekbar.thumbHeight
            )
        }
    }
}