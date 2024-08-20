package com.example.jaygoo_rangeseekbar.fragments

import android.view.View
import com.example.jaygoo_rangeseekbar.R
import com.jaygoo.widget.RangeSeekBar
import java.util.ArrayList


class StepsSeekBarFragment : BaseFragment() {
	override fun getLayoutId(): Int {
		return R.layout.fragment_step
	}

	override fun initView(view: View) {
		val sbSteps1 = view.findViewById<RangeSeekBar>(R.id.sb_steps_1)
		val sbSteps2 = view.findViewById<RangeSeekBar>(R.id.sb_steps_2)

		val stepsDrawables = ArrayList<Int>()
		stepsDrawables.add(R.drawable.step_1)
		stepsDrawables.add(R.drawable.step_2)
		stepsDrawables.add(R.drawable.step_3)
		stepsDrawables.add(R.drawable.step_4)
		sbSteps1?.setStepsDrawable(stepsDrawables)
		sbSteps2?.setStepsDrawable(stepsDrawables)
	}


}