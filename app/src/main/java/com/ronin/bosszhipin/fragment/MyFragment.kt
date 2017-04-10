package com.ronin.bosszhipin.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import com.ronin.bosszhipin.R
import com.ronin.bosszhipin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_my.view.*

/**
 * Created by Administrator on 2017/4/1.
 */
class MyFragment : BaseFragment() {

    lateinit var mWebView: WebView

    override fun createView(inflater: LayoutInflater?,
                            container: ViewGroup?, savedInstanceState: Bundle?) {

        mWebView = rootView!!.webView

        mWebView.getSettings().setJavaScriptEnabled(true)
        mWebView.setFocusableInTouchMode(true)
        mWebView.setFocusable(true)

        supportApi(19) {
            mWebView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }


    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my
    }

    fun <T> supportApi(sdkInt: Int, code: () -> T) {
        if (Build.VERSION.SDK_INT >= sdkInt) {
            code()
        }
    }

}