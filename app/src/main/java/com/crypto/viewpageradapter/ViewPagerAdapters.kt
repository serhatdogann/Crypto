package com.example.kripto.viewpageradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.crypto.Fragments.DusenlerFragment
import com.crypto.Fragments.FavotiresFragment
import com.crypto.Fragments.YukselenlerFragment
import com.crypto.ui.CryptoFragment


class ViewPagerAdapters(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CryptoFragment()
            1 -> FavotiresFragment()
            2 -> YukselenlerFragment()
            3 -> DusenlerFragment()
            else -> {
                Fragment()
            }
        }
    }
}
