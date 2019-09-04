package com.yifan.ebillcenter.ui

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.annotation.IdRes
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.MvRx
import com.yifan.ebillcenter.R
import com.yifan.ebillcenter.util.simpleController
import com.yifan.ebillcenter.views.eBillItemView
import com.yifan.ebillcenter.views.itemSearchView

/**
 * A placeholder fragment containing a simple view.
 */
class BillListFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setImageResource(R.drawable.ic_add)
        fab.setOnClickListener {
            navigate(R.id.serviceSearchFragment)
        }
    }

    override fun epoxyController() = simpleController(viewModel) { state ->
//        itemSearchView {
//            id("Search View")
//            onQueryChanged { Log.d("Yifan", "Changed : $it");true }
//            onQuerySubmit { Log.d("Yifan", "Submit : $it");true  }
//        }

        for (item in state.serviceList) {
            eBillItemView {
                id(item.serviceId)
                itemName("Name : ${item.serviceName}")
                itemPricePm(item.servicePrice)
            }
        }

    }


    protected fun navigate(@IdRes id: Int, args: Parcelable? = null) {
        findNavController().navigate(id, Bundle().apply { putParcelable(MvRx.KEY_ARG, args) })
    }
}
