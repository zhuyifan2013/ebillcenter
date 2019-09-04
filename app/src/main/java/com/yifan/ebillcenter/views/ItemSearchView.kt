package com.yifan.ebillcenter.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.SearchView
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.yifan.ebillcenter.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ItemSearchView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SearchView(context, attrs, defStyleAttr) {

    private val queryListener = OnItemSearchQueryChanged(
            { onQueryChanged?.invoke(it) ?: true }, { onQuerySubmit?.invoke(it) ?: true })

    init {

    }
    @AfterPropsSet
    fun useProps() {
        this.setOnQueryTextListener(queryListener)
        this.queryHint = resources.getString(R.string.search_hint)

    }

    @set:CallbackProp
    var onQueryChanged: ((newText: String?) -> Boolean)? = null

    @set:CallbackProp
    var onQuerySubmit: ((newText: String?) -> Boolean)? = null

    private class OnItemSearchQueryChanged(
            val onQueryChanged: ((newText: String?) -> Boolean),
            val onQuerySubmit: ((newText: String?) -> Boolean)
    ) : OnQueryTextListener {
        override fun onQueryTextChange(newText: String?): Boolean {
            return onQueryChanged.invoke(newText)
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            return onQuerySubmit.invoke(query)
        }
    }
}