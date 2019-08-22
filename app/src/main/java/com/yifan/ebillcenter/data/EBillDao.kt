package com.yifan.ebillcenter.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface EBillDao {

    @Query("select * from bill_items")
    fun getEBillItems(): Single<List<BillItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEBillItem(billItem: BillItem): Long
}