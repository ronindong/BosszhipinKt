package com.ronin.bosszhipin.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Administrator on 2017/4/1.
 */
open abstract class BaseFragment : Fragment() {

    protected var rootView: View? = null

    override final fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(getLayoutId(), container, false)

        createView(inflater,container,savedInstanceState)
        return rootView
    }


    protected abstract fun createView(inflater: LayoutInflater?,
                                      container: ViewGroup?, savedInstanceState: Bundle?): Unit

    protected abstract fun getLayoutId(): Int


}