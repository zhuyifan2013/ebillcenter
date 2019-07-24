package com.yifan.ebillcenter

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

data class BillListState(
        val billList: Int
) : MvRxState

class BillListViewModel(initialState: BillListState) : BaseMvRxViewModel<BillListState>(initialState, debugMode = true) {

    init {
        fetchBillList()
    }

    private fun fetchBillList() {

    }

}