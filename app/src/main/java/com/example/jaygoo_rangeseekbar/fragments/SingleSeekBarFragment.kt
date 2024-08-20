package com.example.jaygoo_rangeseekbar.fragments

import android.graphics.Typeface
import android.view.View
import android.widget.SeekBar
import com.example.jaygoo_rangeseekbar.R
import com.jaygoo.widget.OnRangeChangedListener
import com.jaygoo.widget.RangeSeekBar

class SingleSeekBarFragment : BaseFragment() {
	override fun getLayoutId(): Int {
		return R.layout.fragment_single
	}

	override fun initView(view: View) {
		val sbSingle1 = view.findViewById<RangeSeekBar>(R.id.sb_single1)
		val sbSingle2 = view.findViewById<RangeSeekBar>(R.id.sb_single2)
		val sbSingle3 = view.findViewById<RangeSeekBar>(R.id.sb_single3)
		val sbSingle4 = view.findViewById<RangeSeekBar>(R.id.sb_single4)
		val sbSingle5 = view.findViewById<RangeSeekBar>(R.id.sb_single5)
		val sbSingle6 = view.findViewById<RangeSeekBar>(R.id.sb_single6)

		sbSingle1?.setProgress(10f)
		sbSingle2?.setProgress(20f)
		sbSingle3?.setProgress(30f)
		sbSingle4?.setProgress(40f)
		sbSingle4?.setIndicatorTextDecimalFormat("0.00")
		sbSingle4?.setIndicatorTextStringFormat("%s%%")
		sbSingle5?.setIndicatorTextDecimalFormat("0")

		sbSingle6?.setTypeface(Typeface.SANS_SERIF)
		sbSingle6?.setOnRangeChangedListener(object : OnRangeChangedListener {
			override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
				when {
					leftValue < 33.33 -> rangeSeekBar.leftSeekBar.setIndicatorText("赶往店中")
					leftValue < 66.66 -> rangeSeekBar.leftSeekBar.setIndicatorText("制作中")
					else -> rangeSeekBar.leftSeekBar.setIndicatorText("配送中")
				}

				if (rangeSeekBar.rangeSeekBarState[0].isMin) {
					rangeSeekBar.leftSeekBar.setIndicatorText("商家接单")
				} else if (rangeSeekBar.rangeSeekBarState[0].isMax) {
					rangeSeekBar.leftSeekBar.setIndicatorText("已送达")
				}
			}

			override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {
				// Handle start tracking
			}

			override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {
				// Handle stop tracking
			}

		})
	}
}
