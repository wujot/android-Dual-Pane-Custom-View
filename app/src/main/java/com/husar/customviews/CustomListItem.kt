package com.husar.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout

class CustomListItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    @JvmField
    var index: Int? = null

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.sample_custom_list_item, this, true)
    }
}