package com.betatech.reactnativeintegration

import android.app.Application
import android.content.Context
import com.betatech.react.ReactModule
import com.betatech.react.ReactUtils
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors.newSingleThreadExecutor

class MyApplication : Application(), ReactApplication {

    val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    protected var _reactNativeHost: ReactNativeHost = ReactModule().provideReactNativeHost(this)

    override fun onCreate() {
        super.onCreate()
        initBackground(applicationContext)
    }

    override fun getReactNativeHost(): ReactNativeHost {
        return _reactNativeHost
    }

    private fun initBackground(context: Context) = newSingleThreadExecutor().execute {
        runBlocking {
            ReactUtils(context, _reactNativeHost).initialiseSoLoader()
        }
    }
}