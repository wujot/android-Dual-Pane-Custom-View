package com.husar.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import com.husar.customviews.adapter.CustomAdapter
import com.husar.customviews.model.Item
import kotlinx.android.synthetic.main.sample_custom_list_view.view.*

class CustomListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout (context, attrs, defStyle, defStyleRes) {

    var onItemSelectedListener: ((Int) -> Unit)? = null

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.sample_custom_list_view, this, true)

        //val items = arrayListOf<String>("Item 1", "Item 2", "Item 3", "Item 4")

        var list = listOf(
            Item(R.drawable.baseline_person_black_36dp, R.string.item_title_person),
            Item(R.drawable.baseline_domain_black_36dp, R.string.item_title_community),
            Item(R.drawable.baseline_public_black_36dp, R.string.item_title_social),
            Item(R.drawable.baseline_share_black_36dp, R.string.item_title_share))

        // array Adapter
        //val arrayAdapter = ArrayAdapter(this.context, android.R.layout.simple_list_item_1, items)
        //list_item.adapter = arrayAdapter
        list_item.adapter = CustomAdapter(this.context, R.layout.item_row, list)
        list_item.setOnItemClickListener { adapterView, view, position, id ->
            println(position)
            onItemSelectedListener!!.invoke(position)
        }
    }
}

