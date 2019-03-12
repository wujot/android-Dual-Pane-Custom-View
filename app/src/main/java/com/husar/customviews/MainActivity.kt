package com.husar.customviews

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.sample_custom_list_item.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var customListItem: CustomListItem

    private var itemIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize custom list view
        val customListView = findViewById<CustomListView>(R.id.custom_list_view)

        itemIndex = savedInstanceState?.getInt("index") ?: 0

        if (isDual()) {
            // initialize custom list item
            customListItem = findViewById(R.id.custom_list_item)
            customListItem.item_details.text = itemIndex.toString().trim()
            customListView.onItemSelectedListener = { index ->
                setIndexOfClickedItem(index)
            }
        } else {
            customListView.onItemSelectedListener = { index ->
                sendIndexToDetailActivity(index)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("index", itemIndex)
    }

    // get orientation
    private fun isDual() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    private fun setIndexOfClickedItem(index: Int) {
        itemIndex = index
        customListItem.item_details.text = index.toString().trim()
    }

    private fun sendIndexToDetailActivity(index: Int) {
        itemIndex = index
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key", index)
        startActivity(intent)
    }
}
