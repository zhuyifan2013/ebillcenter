package com.yifan.ebillcenter.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "builtin_services")
data class BuiltInServiceItem(

        @PrimaryKey
        @Json(name = "service_id")
        @ColumnInfo(name = "service_id")
        var serviceId: Int,

        @Json(name = "service_name")
        @ColumnInfo(name = "service_name")
        var serviceName: String = "",

        @Json(name = "service_price")
        @ColumnInfo(name = "service_price")
        var servicePrice: Float = 0f,

        @Json(name = "price_period")
        @ColumnInfo(name = "price_period")
        var pricePeriod: Int = 0,

        @Json(name = "service_icon")
        @ColumnInfo(name = "service_icon")
        var serviceIcon: String = "",

        @Json(name = "service_provider")
        @ColumnInfo(name = "service_provider")
        var serviceProvider: String = ""
)

@JsonClass(generateAdapter = true)
data class BuiltInService(
        @Json(name = "version")
        var version: Int = 0,

        @Json(name = "items")
        var serviceItems: List<BuiltInServiceItem>

)

@Fts4(contentEntity = BuiltInServiceItem::class)
@Entity(tableName = "builtin_services_fts")
data class BuiltinServiceFts(

        @PrimaryKey
        @ColumnInfo(name = "rowid")
        var rowid: Int = 0,

        @ColumnInfo(name = "service_name")
        var serviceName: String = ""
)

fun List<BuiltInServiceItem>.convertToFts(): List<BuiltinServiceFts> {
    val result = emptyList<BuiltinServiceFts>().toMutableList()
    this.forEach {
        result.add(BuiltinServiceFts(it.serviceId, it.serviceName))
    }
    return result
}