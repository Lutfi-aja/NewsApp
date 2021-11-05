package com.upi.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.upi.newsapp.adapter.SectionPagerActivity

class MainActivity : AppCompatActivity() {

    private var mSectionPagerActivity: SectionPagerActivity? = null
    private lateinit var vpNews: ViewPager2
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //untuk build toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

//        val vpNews: ViewPager2 = findViewById(R.id.vp_news)
//        val tabs: TabLayout = findViewById(R.id.tabs)

        vpNews = findViewById(R.id.vp_news)
        tabs = findViewById(R.id.tabs)

        // inisiasi value di variable mSection adapter
        mSectionPagerActivity = SectionPagerActivity(this)

        //set view adapter di viewPager
        vpNews.adapter = mSectionPagerActivity

        //title di tab layout
        val tabList = arrayOf("All News", "Top", "Popular")

        //build title di tab layout
        TabLayoutMediator(tabs, vpNews){tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}