package com.yifan.ebillcenter.data

import androidx.room.*
import io.reactivex.Single

@Dao
interface EServiceManagerDao {

    @Query("select * from service_items")
    fun getServiceItems(): Single<List<ServiceItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveServiceItem(serviceItem: ServiceItem): Long

    @Query("select * from builtin_services")
    fun getBuiltinServiceItems(): Single<List<BuiltInServiceItem>>

    @Query("select * from builtin_services where service_id=:id")
    fun getBuiltinServiceItemById(id: Int): BuiltInServiceItem

    @Transaction
    fun putBuiltinServices(builtinServiceList: List<BuiltInServiceItem>) {

        deleteAllBuiltinServicesFts()
        deleteAllBuiltinServices()

        insertAllBuiltinServices(builtinServiceList)
        insertAllBuiltinServicesFts(builtinServiceList.convertToFts())
    }

    @Insert
    fun insertAllBuiltinServices(builtinServiceList: List<BuiltInServiceItem>)

    @Insert
    fun insertAllBuiltinServicesFts(builtinServiceList: List<BuiltinServiceFts>)

    @Query("delete from builtin_services")
    fun deleteAllBuiltinServices()

    @Query("delete from builtin_services_fts")
    fun deleteAllBuiltinServicesFts()

    @Query("select `rowid`, * from builtin_services_fts where builtin_services_fts match :query ")
    fun searchService(query: String): Single<BuiltinServiceFts>

}