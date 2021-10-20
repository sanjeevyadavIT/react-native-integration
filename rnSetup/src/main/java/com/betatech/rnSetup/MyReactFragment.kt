package com.betatech.rnSetup

import android.app.Application
import android.os.Bundle
import com.facebook.react.ReactFragment
import com.facebook.react.ReactNativeHost
import org.json.JSONObject

class MyReactFragment(application: Application): ReactFragment() {

    companion object {
        private const val ARG_COMPONENT_NAME = "arg_component_name"
        private const val ARG_LAUNCH_OPTIONS = "arg_launch_options"
        const val ARG_DATA = "data"
        private const val KEY_REFERRER = "referrer"
        private fun createBundleData(extra: String?) = Bundle().apply {
            extra?.let {
                val jsonObject = JSONObject(extra)
                putString(ARG_DATA, jsonObject.toString())
            }
        }
        fun newInstance(_application: Application, componentName: String, extras: String? = null, referrer: String? = null): MyReactFragment {
            val bundle = Bundle().apply {
                putString(ARG_COMPONENT_NAME, componentName)
                putBundle(ARG_LAUNCH_OPTIONS, createBundleData(extras))
                putString(KEY_REFERRER, referrer)
            }
            return MyReactFragment(_application).apply { arguments = bundle }
        }
    }

    var rnHost: ReactNativeHost = ReactModule().provideReactNativeHost(application)

    override fun getReactNativeHost() = rnHost
}