package com.mb.juneandroidbatch.viewpager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mb.juneandroidbatch.R
import com.mb.juneandroidbatch.viewpager.fragment.BlankFragment1
import com.mb.juneandroidbatch.viewpager.fragment.BlankFragment2
import com.mb.juneandroidbatch.viewpager.fragment.BlankFragment3

class ViewPagers : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private  lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_pager2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        viewPager  = findViewById(R.id.vp)
        tabLayout  = findViewById(R.id.tab_Layout)


        viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.addFragment(BlankFragment1(), "Chat")
        viewPagerAdapter.addFragment(BlankFragment2(), "status")
        viewPagerAdapter.addFragment(BlankFragment3(), "calls")

        viewPager.adapter = viewPagerAdapter


        TabLayoutMediator(tabLayout, viewPager){
            tab, position ->

            tab.text = viewPagerAdapter.getPageTitle(position)
        }.attach()


    }
}


/** Room is a Android librarby -> used for local database
 *
 * Entity :
 * DAO(Data Access object)
 * Database :
 *
 */