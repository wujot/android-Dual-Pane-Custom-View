package com.husar.customviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.sample_custom_list_item.view.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // initialize custom list item
        val customListItemView = findViewById<CustomListItem>(R.id.custom_list_item)

        // get index
        val index = intent.getIntExtra("key", 0)

        customListItemView.item_details.text = index.toString().trim()
    }
}
