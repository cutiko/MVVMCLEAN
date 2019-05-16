package cl.cutiko.mvvmclean.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainFragmentsAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    companion object {
        private const val FRAGMENTS = 2
    }

    override fun getItem(position: Int): Fragment {
        return Fragment()
    }

    override fun getCount(): Int = FRAGMENTS


}