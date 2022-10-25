package com.example.analyticssample

import android.app.Application

class ApplicationExtension : Application() {
    companion object {
        lateinit var analyticsWrapper: AnalyticsWrapper
    }
    override fun onCreate() {
        super.onCreate()
        analyticsWrapper = AnalyticsWrapper(this)
    }
}