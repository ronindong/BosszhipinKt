package com.ronin.bosszhipin.fragment

import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ronin.bosszhipin.R
import com.ronin.bosszhipin.base.BaseFragment
import com.ronin.learn.adapter.MyAdapter
import kotlinx.android.synthetic.main.fragment_job.view.*
import kotlinx.android.synthetic.main.layout_recyclerview.view.*

/**
 * Created by Administrator on 2017/4/1.
 */
class JobFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {


    var rootView: View? = null
    val adapter = MyAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        rootView = inflater?.inflate(R.layout.fragment_job, container, false)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(rootView!!.tool_bar)
        initView()

        return rootView
    }

    private fun initView() {
        rootView!!.tool_bar.title = "android"

        rootView!!.swipeLayout.setOnRefreshListener(this)
//        adapter.openLoadAnimation()
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        adapter.setNotDoAnimationCount(3)

        rootView!!.recyclerView.layoutManager = LinearLayoutManager(activity)
        rootView!!.recyclerView.adapter = adapter

    }


    override fun onRefresh() {

        Handler().postDelayed({ rootView!!.swipeLayout.isRefreshing = false }, 2000)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu!!.clear()
        inflater!!.inflate(R.menu.job_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return super.onOptionsItemSelected(item)
    }

}