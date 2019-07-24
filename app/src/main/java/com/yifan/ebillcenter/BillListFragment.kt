package com.yifan.ebillcenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState

/**
 * A placeholder fragment containing a simple view.
 */
class BillListFragment : BaseFragment() {

    private val billListViewModel by fragmentViewModel(BillListViewModel::class)

    override fun invalidate() {
        withState(billListViewModel) {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}
