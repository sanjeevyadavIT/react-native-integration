package com.betatech.reactnativeintegration

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.betatech.react.MyReactFragment
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler

class MyReactActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frameLayout = createFrameLayout()
        setContentView(frameLayout)
        loadReactFragment(frameLayout)
    }

    private fun createFrameLayout() =
        FrameLayout(this).apply {
            id = View.generateViewId()
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

    private fun loadReactFragment(view: FrameLayout) {
        supportFragmentManager.commit {
            add(
                view.id,
                MyReactFragment.newInstance(
                    application,
                    "RNProject" /* This string should be same as used in AppRegistry in index.js */
                )
            )
        }
    }

    override fun invokeDefaultOnBackPressed() {
        onBackPressed()
    }
}