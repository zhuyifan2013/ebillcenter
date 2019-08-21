package com.yifan.ebillcenter

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

data class BillListState(
        val billList: Int = 1
) : MvRxState

class BillListViewModel(initialState: BillListState) : MvRxViewModel<BillListState>(initialState) {

    init {
        fetchBillList()
    }

    private fun fetchBillList() {

    }

}