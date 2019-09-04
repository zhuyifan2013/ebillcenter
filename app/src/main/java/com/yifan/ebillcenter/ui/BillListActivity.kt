package com.yifan.ebillcenter.ui

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity
import com.yifan.ebillcenter.R

class BillListActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
