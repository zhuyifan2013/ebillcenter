package com.yifan.ebillcenter

import android.util.Log
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Success
import com.yifan.ebillcenter.data.BillItem
import com.yifan.ebillcenter.data.DBDataSource
import com.yifan.ebillcenter.data.EBillDatabase
import io.reactivex.Observable

data class BillListState(
        val billList: MutableList<BillItem> = emptyList<BillItem>().toMutableList()
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
                    copy(billList = it()?.toMutableList() ?: billList)
                }
    }

    fun addEBillItem(billItem: BillItem) {
        setState {
            copy(billList = (billList + billItem).toMutableList())
        }
        MyApplication.getDBDataSource()?.addEBillItem(billItem)
    }

}