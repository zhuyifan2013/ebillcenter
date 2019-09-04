package com.yifan.ebillcenter.util

import android.content.Context
import android.util.Log
import java.io.File
import java.lang.Exception

class Utils {
    companion object {
        private const val SP_FILE_NAME = "ebillcenter_sp"

        const val SP_KEY_LOAD_PRE_DATA_FINISH = "load_pre_data_finish"

        fun readStringFromAssetFile(context: Context, fileName: String): String? {
            return context.resources.assets.open(fileName).bufferedReader().use { it.readText() }
        }

        fun getStringFromSp(context: Context, key: String): String? {
            val sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
            return sp.getString(key, null)
        }

        fun getBooleanFromSp(context: Context, key: String): Boolean {
            val sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
            return sp.getBoolean(key, false)
        }

        fun putStringIntoSp(context: Context, key: String, value: String) {
            val sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
            with(sp.edit()) {
                putString(key, value)
                apply()
            }
        }

        fun putBooleanIntoSp(context: Context, key: String, value: Boolean) {
            val sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
            with(sp.edit()) {
                putBoolean(key, value)
                apply()
            }
        }
    }
}