package com.yifan.ebillcenter.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.yifan.ebillcenter.R
import com.yifan.ebillcenter.data.BillItem
import com.yifan.ebillcenter.helper.showShortSnackbar
import com.yifan.ebillcenter.util.simpleController
import com.yifan.ebillcenter.views.editItemView

//TODO: Use RxJava to optimize it
class EditItemFragment : BaseFragment() {

    private var billItem:BillItem = BillItem()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setImageResource(R.drawable.ic_done)
        fab.setOnClickListener {
            if(billItem.itemName.isBlank() || billItem.pricePm == 0f) {
                return@setOnClickListener
            }
            viewModel.addEBillItem(billItem)
            findNavController().navigateUp()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Yifan", "onResume : " + System.identityHashCode(this));
        Log.d("Yifan", "This: " + this);
    }
    override fun epoxyController() = simpleController(viewModel) { state ->

        Log.d("Yifan", "333");
        editItemView {
            id("Edit Item")
            onNameChanged { billItem.itemName = it}
            onPriceChanged {
                billItem.pricePm = it.toFloat() }
        }
    }

}