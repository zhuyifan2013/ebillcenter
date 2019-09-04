package com.yifan.ebillcenter.ui

import android.util.Log
import com.yifan.ebillcenter.util.EBillEpoxyController
import com.yifan.ebillcenter.util.simpleController
import com.yifan.ebillcenter.views.itemSearchView

class ServiceSearchFragment : BaseFragment() {

    override fun epoxyController(): EBillEpoxyController = simpleController(viewModel) {

        itemSearchView {
            id("Search View")
            onQueryChanged {
                Log.d("Yifan", "Changed : $it")
                viewModel.searchService(it)
                true
            }
            onQuerySubmit { Log.d("Yifan", "Submit : $it");true }
        }

    }

}