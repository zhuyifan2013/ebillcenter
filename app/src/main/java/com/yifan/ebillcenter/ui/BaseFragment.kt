package com.yifan.ebillcenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yifan.ebillcenter.EBillViewModel
import com.yifan.ebillcenter.R
import com.yifan.ebillcenter.util.EBillEpoxyController

abstract class BaseFragment : BaseMvRxFragment() {

    protected val viewModel by activityViewModel(EBillViewModel::class)

    protected lateinit var coordinatorLayout: CoordinatorLayout
    protected lateinit var recyclerView: EpoxyRecyclerView
    protected val epoxyController by lazy { epoxyController() }
    protected lateinit var fab: FloatingActionButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_base, container, false).apply {
                fab = findViewById(R.id.fab)
                coordinatorLayout = findViewById(R.id.coordinator_layout)
                recyclerView = findViewById(R.id.recycler_view)
                recyclerView.setController(epoxyController)
            }

    override fun invalidate() {
        recyclerView.requestModelBuild()
    }

    abstract fun epoxyController(): EBillEpoxyController
}