package com.yifan.ebillcenter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.yifan.ebillcenter.util.EBillEpoxyController
import com.yifan.ebillcenter.util.simpleController
import com.yifan.ebillcenter.views.EBillItemView_
import com.yifan.ebillcenter.views.eBillItemView

/**
 * A placeholder fragment containing a simple view.
 */
class BillListFragment : BaseFragment() {

    private val billListViewModel by fragmentViewModel(BillListViewModel::class)

    override fun epoxyController() = simpleController(billListViewModel) { state ->

        for (i in 1..5) {
            Log.i("Yifan", "Count : $i")

            eBillItemView {
                id(i)
                itemName("Name : $i")
                itemPricePm(i)
            }
        }

    }

}
