package com.betatech.react

import android.content.Context
import android.util.Log
import com.facebook.react.ReactNativeHost
import com.facebook.soloader.SoLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicBoolean

class ReactUtils constructor(
    private val context: Context,
    private val reactNativeHost: ReactNativeHost
) {

    private val initialised = AtomicBoolean(false)

    suspend fun initialiseSoLoader() {
        if (initialised.get()) return

        withContext(Dispatchers.IO) {
            try {
                SoLoader.init(context, false)
            } catch (e: IllegalStateException) {
                e.message?.let { Log.e("REACT ERROR", it) }
            }
        }
        initialised.set(true)
    }

    suspend fun createReactContextInBackground() {
        if (initialised.get().not())
            initialiseSoLoader()
        reactNativeHost.reactInstanceManager.createReactContextInBackground()
    }
}