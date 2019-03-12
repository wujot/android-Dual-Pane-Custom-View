package com.husar.customviews.adapter

import android.content.ClipData
import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.husar.customviews.R
import com.husar.customviews.model.Item

class CustomAdapter(var mCtx: Context, var resource:Int, var items:List<Item>)
    : ArrayAdapter<Item>( mCtx , resource , items ){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        val imageView : ImageView = view.findViewById(R.id.icon)
        var textView : TextView = view.findViewById(R.id.title)


        var item : Item = items[position]

        imageView.setImageDrawable(mCtx.resources.getDrawable(item.icon))
        textView.text = mCtx.resources.getString(item.title)

        return view
    }

}