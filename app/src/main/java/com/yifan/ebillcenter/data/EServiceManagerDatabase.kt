package com.yifan.ebillcenter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ServiceItem::class, BuiltInServiceItem::class, BuiltinServiceFts::class], version = 1)
abstract class EServiceManagerDatabase : RoomDatabase() {

    abstract fun serviceItemDao(): EServiceManagerDao

    companion object {

        private var INSTANCE: EServiceManagerDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): EServiceManagerDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.applicationContext, EServiceManagerDatabase::class.java, "ebillcenter.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}