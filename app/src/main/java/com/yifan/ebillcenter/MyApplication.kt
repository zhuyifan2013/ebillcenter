package com.yifan.ebillcenter

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.soloader.SoLoader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.yifan.ebillcenter.data.DBDataSource
import com.yifan.ebillcenter.data.EServiceManagerDatabase

class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            client.addPlugin(DatabasesFlipperPlugin(this))
            client.start()
        }

        dbDataSource = DBDataSource(EServiceManagerDatabase.getInstance(this).serviceItemDao())
        moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        dbDataSource?.initPreData(this)


    }

    companion object {
        private var dbDataSource: DBDataSource? = null
        private var moshi: Moshi? = null

        fun getDBDataSource(): DBDataSource? {
            return dbDataSource
        }

        fun getMoshi(): Moshi? {
            return moshi
        }

    }
}