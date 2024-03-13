package com.crypto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.crypto.R
import com.example.kripto.viewpageradapter.ViewPagerAdapters
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabs: TabLayout = findViewById(R.id.Tabs)

        val adapter = ViewPagerAdapters(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Kriptolar"
                1 -> tab.text = "Favoriler"
                2 -> tab.text = "Yükselenler"
                3 -> tab.text = "Düşenler"

                else -> tab.text = ""
            }
        }.attach()




    }
}