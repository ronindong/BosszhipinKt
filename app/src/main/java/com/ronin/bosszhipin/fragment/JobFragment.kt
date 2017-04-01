package com.ronin.bosszhipin.fragment

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronin.bosszhipin.R
import com.ronin.bosszhipin.base.BaseFragment

/**
 * Created by Administrator on 2017/4/1.
 */
class JobFragment : BaseFragment() {

     var toolBar:Toolbar? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater?.inflate(R.layout.fragment_job, container,false)

        toolBar = rootView?.findViewById(R.id.toolbar) as? Toolbar

        toolBar?.title = "Title"
        toolBar?.setNavigationIcon(R.drawable.ic_search_black_24dp)

//        UI {
//            coordinatorLayout {
//                fitsSystemWindows = true
//
//            }
//        }


        return rootView
    }


}