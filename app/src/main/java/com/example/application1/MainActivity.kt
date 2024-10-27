package com.example.application1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerview : RecyclerView
    lateinit var button : Button

    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerview)
        button = findViewById(R.id.button)

        recyclerview.adapter = adapter

        button.setOnClickListener {
            adapter.addItem(adapter.itemCount + 1)
        }

        if(savedInstanceState != null)
        {
            val n = savedInstanceState.getInt("size")
            for (i in 1..n) {
                adapter.addItem(i)
            }
        }
        //adapter.setItems(listOf(1, 2, 3))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("size", adapter.itemCount)
    }
}