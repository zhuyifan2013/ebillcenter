package com.yifan.ebillcenter.data

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DBDataSource(private val dao: EBillDao) {

    fun getEBillItems(): Single<List<BillItem>> {
        return dao.getEBillItems().subscribeOn(Schedulers.io())
    }

    fun addEBillItem(eBillItem: BillItem) {
        fromAction { dao.saveEBillItem(eBillItem) }
    }

    private fun fromAction(action: () -> Unit): Disposable = Completable.fromAction(action)
            .subscribeOn(Schedulers.io())
            .subscribe()
}