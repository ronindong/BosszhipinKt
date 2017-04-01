package com.ronin.bosszhipin.activity

import android.content.Context
import android.widget.Toast

/**
 * Created by Administrator on 2017/4/1.
 */

/**
 * Context 扩展函数toast
 */
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}