package org.shettyyttehs.counter

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class MyApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var _Context: Context
        val Context: Context
            get() = _Context
    }

    override fun onCreate() {
        super.onCreate()
        _Context = applicationContext
    }
}