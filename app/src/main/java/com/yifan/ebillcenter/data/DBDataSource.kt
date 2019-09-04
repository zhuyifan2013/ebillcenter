package com.yifan.ebillcenter.data

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.yifan.ebillcenter.MyApplication
import com.yifan.ebillcenter.util.Utils
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DBDataSource(private val dao: EServiceManagerDao) {


    // Load pre-built data into database
    @SuppressLint("CheckResult")
    fun initPreData(context: Context) {
        if (!Utils.getBooleanFromSp(context, Utils.SP_KEY_LOAD_PRE_DATA_FINISH)) {
            Single.fromCallable { Utils.readStringFromAssetFile(context, "builtin_services.json") }
                    .subscribeOn(Schedulers.io())
                    .map {
                        val adapter: JsonAdapter<BuiltInService>? = MyApplication.getMoshi()
                                ?.adapter(BuiltInService::class.java)
                        adapter?.fromJson(it)?.apply {
                            dao.putBuiltinServices(this.serviceItems)
                        }
                    }
                    .subscribe({ Log.d("Yifan", "Result : $it"); }, { Log.d("Yifan", "error : $it"); })

        }
    }

    fun getEBillItems(): Single<List<ServiceItem>> {
        return dao.getServiceItems().subscribeOn(Schedulers.io())
    }

    fun addEBillItem(eServiceItem: ServiceItem) {
        fromAction { dao.saveServiceItem(eServiceItem) }
    }

    fun searchService(query: String): Single<BuiltInServiceItem> {
        return dao.searchService("*$query*").subscribeOn(Schedulers.io()).map {
            dao.getBuiltinServiceItemById(it.rowid)
        }
    }

    private fun fromAction(action: () -> Unit): Disposable = Completable.fromAction(action)
            .subscribeOn(Schedulers.io())
            .subscribe()

}