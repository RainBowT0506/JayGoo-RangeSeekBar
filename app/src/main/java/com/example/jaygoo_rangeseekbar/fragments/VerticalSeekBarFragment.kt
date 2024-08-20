package com.example.jaygoo_rangeseekbar.fragments

import android.view.View
import com.example.jaygoo_rangeseekbar.R
import com.jaygoo.widget.OnRangeChangedListener
import com.jaygoo.widget.RangeSeekBar
import com.jaygoo.widget.SeekBar
import com.jaygoo.widget.Utils
import java.util.ArrayList

class VerticalSeekBarFragment : BaseFragment() {

	override fun getLayoutId(): Int {
		return R.layout.fragment_vertical
	}

	override fun initView(view: View) {
		// 获取 RangeSeekBar 的引用
		val sbVertical2 = view.findViewById<RangeSeekBar>(R.id.sb_vertical_2)
		val sbVertical3 = view.findViewById<RangeSeekBar>(R.id.sb_vertical_3)
		val sbVertical4 = view.findViewById<RangeSeekBar>(R.id.sb_vertical_4)
		val sbVertical6 = view.findViewById<RangeSeekBar>(R.id.sb_vertical_6)
		val sbVertical7 = view.findViewById<RangeSeekBar>(R.id.sb_vertical_7)
		val sbVertical8 = view.findViewById<RangeSeekBar>(R.id.sb_vertical_8)
		val sbVertical9 = view.findViewById<RangeSeekBar>(R.id.sb_vertical_9)

		// 初始化 Vertical SeekBars
		sbVertical2?.apply {
			setIndicatorTextDecimalFormat("0.0")
			setProgress(0f, 100f)
			changeSeekBarThumb(leftSeekBar, leftSeekBar.progress)
			changeSeekBarThumb(rightSeekBar, rightSeekBar.progress)
			setOnRangeChangedListener(object : OnRangeChangedListener {
				override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
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
		}

		sbVertical3?.setIndicatorTextDecimalFormat("0")
		sbVertical4?.apply {
			setIndicatorTextDecimalFormat("0")
			setIndicatorTextStringFormat("%s%%")
			setProgress(30f, 60.6f)
		}

		sbVertical6?.setProgress(30f)
		sbVertical7?.setProgress(40f, 80f)
		sbVertical8?.setIndicatorTextDecimalFormat("0.0")

		val stepsDrawables = arrayListOf(
			R.drawable.step_1,
			R.drawable.step_2,
			R.drawable.step_3,
			R.drawable.step_1
		)

		sbVertical9?.apply {
			setStepsDrawable(stepsDrawables)
			changeSeekBarIndicator(leftSeekBar, leftSeekBar.progress)
			changeSeekBarIndicator(rightSeekBar, rightSeekBar.progress)
			setOnRangeChangedListener(object : OnRangeChangedListener {
				override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
					changeSeekBarIndicator(rangeSeekBar.leftSeekBar, leftValue)
					changeSeekBarIndicator(rangeSeekBar.rightSeekBar, rightValue)
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

	private fun changeSeekBarThumb(seekbar: SeekBar, value: Float) {
		if (value < 33) {
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorAccent)
			seekbar.setThumbDrawableId(R.drawable.thumb_green, seekbar.thumbWidth, seekbar.thumbHeight)
		} else if (value < 66) {
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorProgress)
			seekbar.setThumbDrawableId(R.drawable.thumb_yellow, seekbar.thumbWidth, seekbar.thumbHeight)
		} else {
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorRed)
			seekbar.setThumbDrawableId(R.drawable.thumb_red, seekbar.thumbWidth, seekbar.thumbHeight)
		}
	}

	private fun changeSeekBarIndicator(seekbar: SeekBar, value: Float) {
		seekbar.showIndicator(true)
		when {
			Utils.compareFloat(value, 0f, 3) == 0 || Utils.compareFloat(value, 100f, 3) == 0 -> seekbar.setIndicatorText("smile")
			Utils.compareFloat(value, 100 / 3f, 3) == 0 -> seekbar.setIndicatorText("naughty")
			Utils.compareFloat(value, 200 / 3f, 3) == 0 -> seekbar.setIndicatorText("lovely")
			else -> seekbar.showIndicator(false)
		}
	}
}
