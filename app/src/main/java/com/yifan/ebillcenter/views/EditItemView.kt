package com.yifan.ebillcenter.views

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.yifan.ebillcenter.R

@ModelView(defaultLayout = R.layout.edit_item)
class EditItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        Log.d("Yifan", "Init View : " + this);
    }
    private val itemNameView by lazy { findViewById<EditText>(R.id.item_name) }
    private val itemPriceView by lazy { findViewById<EditText>(R.id.item_price_pm) }

    private val nameWatcher = SimpleTextWatcher { onNameChanged?.invoke(it) }
    private val priceWatcher = SimpleTextWatcher { onPriceChanged?.invoke(it) }

    @AfterPropsSet
    fun useProps() {
        itemNameView.addTextChangedListener(nameWatcher)
        itemPriceView.addTextChangedListener(priceWatcher)
    }

    @set:CallbackProp
    var onNameChanged: ((newText: String) -> Unit)? = null

    @set:CallbackProp
    var onPriceChanged: ((newText: String) -> Unit)? = null

    private class SimpleTextWatcher(val onTextChanged: (newText: String) -> Unit) : TextWatcher {
        override fun afterTextChanged(s: Editable) {
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            onTextChanged(s.toString())
        }
    }
}
