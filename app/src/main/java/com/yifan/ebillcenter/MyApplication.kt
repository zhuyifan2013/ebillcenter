package com.yifan.ebillcenter

import android.app.Application
import com.yifan.ebillcenter.data.DBDataSource
import com.yifan.ebillcenter.data.EBillDatabase

class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        dbDataSource = DBDataSource(EBillDatabase.getInstance(this).ebillDao())
    }

    companion object {
        private var dbDataSource: DBDataSource? = null

        fun getDBDataSource(): DBDataSource? {
            return dbDataSource
        }
    }
}