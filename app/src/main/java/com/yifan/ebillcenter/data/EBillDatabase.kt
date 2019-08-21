package com.yifan.ebillcenter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BillItems::class], version = 1)
abstract class EBillDatabase : RoomDatabase() {

    abstract fun ebillDao() : EBillDao

    companion object {

        private var INSTANCE: EBillDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): EBillDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.applicationContext, EBillDatabase::class.java, "ebillcenter.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}