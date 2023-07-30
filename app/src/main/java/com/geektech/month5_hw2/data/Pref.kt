package com.geektech.month5_hw2.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(private val context: Context) {

    private val pref by lazy {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }

    fun isOnBoardSeen(): Boolean {
        return pref.getBoolean(SEEN_KEY, false)
    }

    fun saveOnBoardSeen() {
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    companion object {
        const val PREF_NAME = "calculator.name"
        const val SEEN_KEY = "onboard.see"
    }
}