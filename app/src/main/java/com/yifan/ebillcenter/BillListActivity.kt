package com.yifan.ebillcenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BillListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, BillListFragment())
                .commitNow()
    }
}
