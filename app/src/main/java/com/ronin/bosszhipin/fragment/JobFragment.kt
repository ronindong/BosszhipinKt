package com.ronin.bosszhipin.fragment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.ronin.bosszhipin.R
import com.ronin.bosszhipin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_job.view.*

/**
 * Created by Administrator on 2017/4/1.
 */
class JobFragment : BaseFragment() {

    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        rootView = inflater?.inflate(R.layout.fragment_job, container, false)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(rootView!!.tool_bar)
        rootView!!.tool_bar.title = "android"


        return rootView
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu!!.clear()
        inflater!!.inflate(R.menu.navigation, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return super.onOptionsItemSelected(item)
    }

}