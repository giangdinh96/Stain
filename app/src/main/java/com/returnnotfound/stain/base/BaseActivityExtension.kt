package com.returnnotfound.stain.base

import android.app.Activity
import android.content.Context
import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment

fun Activity.getContext(): Context = this

fun Activity.getBaseActivity(): BaseActivity? = this as BaseActivity


// Fragment
fun BaseFragment.getBaseActivity(): BaseActivity? = activity as? BaseActivity?