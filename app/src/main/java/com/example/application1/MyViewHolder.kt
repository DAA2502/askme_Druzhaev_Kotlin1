package com.example.application1

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    //val mRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
    //private val adapter = MyAdapter()
    val text = view.findViewById<TextView>(R.id.textview)
    val image = view.findViewById<ImageView>(R.id.imageview)

    fun bind(adapter : MyAdapter, number : Int) {
        text.text = "$number"
        image.setOnClickListener {
            adapter.deleteItem(number)
        }
        if(number % 2 == 0)
            image.setBackgroundColor(Color.argb(255, 255, 0, 0))
        else
            image.setBackgroundColor(Color.argb(255, 0, 0, 255))
    }
}