package com.yifan.ebillcenter.util

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.EpoxyController
import com.airbnb.mvrx.MvRxState
import com.yifan.ebillcenter.BaseFragment
import com.yifan.ebillcenter.MvRxViewModel

class EBillEpoxyController(
        val buildModelsCallback: EpoxyController.() -> Unit = {}
) : AsyncEpoxyController() {
    override fun buildModels() {
        buildModelsCallback()
    }
}

fun <S : MvRxState, A : MvRxViewModel<S>> BaseFragment.simpleController(
        viewModel: A,
        buildModels: EpoxyController.(state: S) -> Unit
) = EBillEpoxyController {
    if (view == null || isRemoving) return@EBillEpoxyController
    com.airbnb.mvrx.withState(viewModel) { state ->
        buildModels(state)
    }
}