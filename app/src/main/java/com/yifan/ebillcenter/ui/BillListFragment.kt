package com.yifan.ebillcenter.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.MvRx
import com.yifan.ebillcenter.R
import com.yifan.ebillcenter.util.simpleController
import com.yifan.ebillcenter.views.eBillItemView

/**
 * A placeholder fragment containing a simple view.
 */
class BillListFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setImageResource(R.drawable.ic_add)
        fab.setOnClickListener {
            navigate(R.id.editItemFragment)
        }

    }

    override fun epoxyController() = simpleController(viewModel) { state ->

        for (item in state.billList) {
            eBillItemView {
                id(item.itemId)
                itemName("Name : ${item.itemName}")
                itemPricePm(item.pricePm)
            }
        }

    }

    protected fun navigate(@IdRes id: Int, args: Parcelable? = null) {
        findNavController().navigate(id, Bundle().apply { putParcelable(MvRx.KEY_ARG, args) })
    }
}
