package com.yifan.ebillcenter.views

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.yifan.ebillcenter.R
import com.yifan.ebillcenter.helper.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.ebill_item)
abstract class EBillItemView : EpoxyModelWithHolder<Holder>() {
    @EpoxyAttribute lateinit var itemName : String

    @EpoxyAttribute
    var itemPricePm : Int = 0

    override fun bind(holder: Holder) {
        holder.itemNameView.text = itemName
    }

}


class Holder : KotlinEpoxyHolder() {

    val itemNameView by bind<TextView>(R.id.item_name)
    val itemPricePmView by bind<TextView>(R.id.item_price_pm)

}
