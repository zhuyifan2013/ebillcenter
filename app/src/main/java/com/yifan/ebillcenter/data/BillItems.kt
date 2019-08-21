package com.yifan.ebillcenter.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bill_items")
data class BillItems(
        @PrimaryKey @ColumnInfo(name = "item_id") val itemId: Int,
        @ColumnInfo(name = "item_name") val itemName: String,
        @ColumnInfo(name = "price_pm") val pricePm: Float
)