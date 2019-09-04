package com.yifan.ebillcenter.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.util.*

@Entity(tableName = "service_items")
data class ServiceItem(

        @PrimaryKey
        @Json(name = "service_id")
        @ColumnInfo(name = "service_id")
        var serviceId: String = "",

        @Json(name = "service_name")
        @ColumnInfo(name = "service_name")
        var serviceName: String = "",

        @Json(name = "service_price")
        @ColumnInfo(name = "service_price")
        var servicePrice: Float = 0f,

        @Json(name = "price_period")
        @ColumnInfo(name = "price_period")
        var pricePeriod: Int = 0

)