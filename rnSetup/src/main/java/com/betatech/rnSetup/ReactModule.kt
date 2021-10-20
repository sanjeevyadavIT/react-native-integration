package com.betatech.rnSetup

import android.app.Application
import com.facebook.react.BuildConfig
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.shell.MainReactPackage

class ReactModule {

    fun provideReactNativeHost(
        application: Application
    ): ReactNativeHost {
        return object : ReactNativeHost(application) {
            override fun getUseDeveloperSupport(): Boolean {
                return BuildConfig.DEBUG
            }

            override fun getPackages(): MutableList<ReactPackage> {
                return mutableListOf(
                    MainReactPackage(),
                )
            }
        }
    }
}