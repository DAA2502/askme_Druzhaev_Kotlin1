package com.example.application1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    private var items = ArrayList<Int>()
    private var deletedItems = ArrayDeque<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(this, items[position])
    }

    private fun isDeleted(): Boolean {
        if (deletedItems.size > 0) {
            return true
        }
        else {
            return false
        }
    }

    fun deleteItem(item : Int) {
        deletedItems.addLast(item)
        val index = items.indexOf(item)
        items.remove(item)
        notifyItemRangeRemoved(index, 1)
    }

    fun addItem(item : Int) {
        if (isDeleted()) {
            items.add(deletedItems.removeFirst())
        }
        else {
            items.add(item)
        }
        notifyItemRangeChanged(item, 1)
    }
}