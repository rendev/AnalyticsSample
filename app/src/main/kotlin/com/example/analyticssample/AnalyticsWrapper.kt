package com.example.analyticssample

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import kotlin.math.abs

private const val TEST_CRASH_NAME = "Test crash"
private const val TEST_EVENT_NAME = "Test_event_name"
private const val TEST_EVENT_PARAM_KEY = "Test_event_param_key"
private const val TEST_EVENT_PARAM_VALUE = "Test_event_param_value"
private const val API_KEY = "0af24eeb-e54b-4967-9628-43a3bf997292"

class AnalyticsWrapper(application: Application) {
    private val firebaseAnalytics: FirebaseAnalytics

    init {
        FirebaseApp.initializeApp(application)
        firebaseAnalytics = Firebase.analytics
        val config: YandexMetricaConfig = YandexMetricaConfig.newConfigBuilder(API_KEY).build()
        YandexMetrica.activate(application, config)
        YandexMetrica.enableActivityAutoTracking(application)
    }

    fun login() {
        val random = abs((0..999999999999).random()).toString()
        firebaseAnalytics.setUserId(random)
        YandexMetrica.setUserProfileID(random)
    }

    fun logout() {
        firebaseAnalytics.setUserId(null)
        YandexMetrica.setUserProfileID(null)
    }

    fun sendEvent() {
        firebaseAnalytics.logEvent(TEST_EVENT_NAME) {
            param(TEST_EVENT_PARAM_KEY, TEST_EVENT_PARAM_VALUE)
        }
        YandexMetrica.reportEvent(TEST_EVENT_NAME)
    }

    fun simulateCrash() {
        throw RuntimeException(TEST_CRASH_NAME)
    }
}