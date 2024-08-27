package com.example.jaygoo_rangeseekbar


import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.jaygoo_rangeseekbar.fragments.MySeekBarFragment
import com.example.jaygoo_rangeseekbar.fragments.RangeSeekBarFragment
import com.example.jaygoo_rangeseekbar.fragments.SingleSeekBarFragment
import com.example.jaygoo_rangeseekbar.fragments.StepsSeekBarFragment
import com.example.jaygoo_rangeseekbar.fragments.VerticalSeekBarFragment
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.layout_tab)

        // Set up the ViewPager with the sections adapter.
        viewPager.setAdapter(object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return when (position) {
                    0 -> MySeekBarFragment()
                    1 -> RangeSeekBarFragment() // First tab: RangeSeekBarFragment
                    2 -> SingleSeekBarFragment() // Second tab: SingleSeekBarFragment
                    3 -> StepsSeekBarFragment() // Third tab: StepsSeekBarFragment
                    4 -> VerticalSeekBarFragment() // Fourth tab: VerticalSeekBarFragment
                    else -> RangeSeekBarFragment() // Default case, shouldn't happen
                }
            }

            // Show 4 total pages.
            override fun getCount(): Int {
                return 5
            }

            @Nullable
            override fun getPageTitle(position: Int): CharSequence? {
                return when (position) {
                    0 -> "Custom SeekBar"
                    1 -> "Range SeekBar"
                    2 -> "Single SeekBar"
                    3 -> "Steps SeekBar"
                    4 -> "Vertical SeekBar"
                    else -> null
                }
            }
        })

        tabLayout.setupWithViewPager(viewPager)
    }

}