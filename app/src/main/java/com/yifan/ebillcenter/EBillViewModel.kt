package com.yifan.ebillcenter

import android.annotation.SuppressLint
import android.util.Log
import com.airbnb.mvrx.MvRxState
import com.yifan.ebillcenter.data.ServiceItem

data class BillListState(
        val serviceList: MutableList<ServiceItem> = emptyList<ServiceItem>().toMutableList(),
        val searchResult: MutableList<ServiceItem> = emptyList<ServiceItem>().toMutableList()
) : MvRxState

class EBillViewModel(initialState: BillListState) : MvRxViewModel<BillListState>(initialState) {

    init {
        fetchBillList()
    }

    private fun fetchBillList() {
        MyApplication.getDBDataSource()!!.getEBillItems().toObservable()
                .doOnNext {
                    Log.d("Yifan", "it : $it");
                }.execute {
                    copy(serviceList = it()?.toMutableList() ?: serviceList)
                }
    }

    fun addEBillItem(serviceItem: ServiceItem) {
        setState {
            copy(serviceList = (serviceList + serviceItem).toMutableList())
        }
        MyApplication.getDBDataSource()?.addEBillItem(serviceItem)
    }

    @SuppressLint("CheckResult")
    fun searchService(query: String) {
        MyApplication.getDBDataSource()?.searchService(query)
                ?.subscribe({ Log.d("Yifan", "Result : $it") }, { Log.d("Yifan", "Error : $it"); })
    }

}