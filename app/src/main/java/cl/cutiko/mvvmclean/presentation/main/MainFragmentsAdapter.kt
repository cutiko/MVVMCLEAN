package cl.cutiko.mvvmclean.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

private const val FRAGMENTS = 2

class MainFragmentsAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return Fragment()
    }

    override fun getCount(): Int = FRAGMENTS


}