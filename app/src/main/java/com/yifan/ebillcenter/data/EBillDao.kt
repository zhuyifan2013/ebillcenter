package com.yifan.ebillcenter.data

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Single

@Dao
interface EBillDao {

    @Query("select * from bill_items")
    fun getEBillItems(): Single<BillItems>
}