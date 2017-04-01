package com.ronin.bosszhipin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ronin.bosszhipin.base.BaseFragment
import com.ronin.bosszhipin.util.PageIndex

/**
 * Created by Administrator on 2017/4/1.
 */
class MyFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val tv = TextView(context)
        tv.text = PageIndex.MY.name
        return tv
    }



}