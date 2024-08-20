package com.example.jaygoo_rangeseekbar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.jaygoo_rangeseekbar.fragments.BaseFragment
import com.example.jaygoo_rangeseekbar.fragments.RangeSeekBarFragment
import com.example.jaygoo_rangeseekbar.fragments.SingleSeekBarFragment
import com.example.jaygoo_rangeseekbar.fragments.StepsSeekBarFragment
import com.example.jaygoo_rangeseekbar.fragments.VerticalSeekBarFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private var types: Array<String> = arrayOf("SINGLE", "RANGE", "STEP", "VERTICAL")

    private var fragments: MutableList<BaseFragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        fragments.clear()
        fragments.add(SingleSeekBarFragment())
        fragments.add(RangeSeekBarFragment())
        fragments.add(StepsSeekBarFragment())
        fragments.add(VerticalSeekBarFragment())

        Log.d("MainActivity", "Fragments initialized: ${fragments.size}")

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.layout_tab)
        viewPager.adapter = PagerAdapter(supportFragmentManager, fragments, types)
        tabLayout.setupWithViewPager(viewPager)

        Log.d("MainActivity", "ViewPager and TabLayout setup complete")
    }


    private class PagerAdapter(
        fm: FragmentManager,
        private val fragments: List<Fragment>,
        private val types: Array<String>
    ) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return types[position]
        }
    }

}