package com.ronin.bosszhipin.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.ronin.bosszhipin.R
import com.ronin.bosszhipin.base.BaseActivity
import com.ronin.bosszhipin.fragment.CompanyFragment
import com.ronin.bosszhipin.fragment.JobFragment
import com.ronin.bosszhipin.fragment.MessageFragment
import com.ronin.bosszhipin.fragment.MyFragment
import com.ronin.bosszhipin.util.PageIndex
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                switchFragment(PageIndex.JOB)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                switchFragment(PageIndex.COMPANY)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                switchFragment(PageIndex.MESSAGE)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my -> {
                switchFragment(PageIndex.MY)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private lateinit var mFragManager: FragmentManager
    private var curFragment: Fragment? = null
    private var curPageIndex = PageIndex.JOB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mFragManager = supportFragmentManager
        switchFragment()

    }

    /**
     *
     */
    private fun switchFragment(index: PageIndex = PageIndex.JOB) {
        if (index != curPageIndex || curFragment == null) {
            var fragment: Fragment? = null
            when (index) {
                PageIndex.JOB -> {
                    fragment = JobFragment()
                }
                PageIndex.COMPANY -> {
                    fragment = CompanyFragment()
                }
                PageIndex.MESSAGE -> {
                    fragment = MessageFragment()
                }
                PageIndex.MY -> {
                    fragment = MyFragment()
                }
            }

            val transaction = mFragManager.beginTransaction()
            if (curFragment == null) {
                transaction.add(R.id.content, fragment, index.name)
            } else {

                if (curFragment!!.isAdded && !curFragment!!.isDetached) {
                    transaction.hide(curFragment)
                    curFragment!!.onPause()
                }
                if (fragment.isDetached) {
                    transaction.attach(fragment)
                    fragment.onResume()
                } else if (fragment.isHidden) {
                    transaction.show(fragment)
                } else if (!fragment.isAdded) {
                    transaction.add(R.id.content, fragment, index.name)
                }
            }
            transaction.commitAllowingStateLoss()
            curFragment = fragment
            curPageIndex = index


        }
    }

}
