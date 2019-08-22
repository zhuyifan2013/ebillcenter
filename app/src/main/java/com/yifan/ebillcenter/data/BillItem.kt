package com.yifan.ebillcenter.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "bill_items")
data class BillItem(
        @ColumnInfo(name = "item_name") var itemName: String = "",
        @ColumnInfo(name = "price_pm") var pricePm: Float = 0f,
        @PrimaryKey @ColumnInfo(name = "item_id") var itemId:String = UUID.randomUUID().toString()
)