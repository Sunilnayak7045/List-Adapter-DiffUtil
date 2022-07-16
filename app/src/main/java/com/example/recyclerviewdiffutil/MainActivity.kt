package com.example.recyclerviewdiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleview = findViewById<RecyclerView>(R.id.programmingList)
        val adapter =  ProgrammingAdapter()

        val p1 = ProgrammingItem(1,"J", "Java")
        val p2 = ProgrammingItem(2,"G", "Go")
        val p3 = ProgrammingItem(3,"R", "Ruby")


        adapter.submitList(listOf(p1,p2,p3))
        //To set the data in adapter
        //submitList method is used to pass the list to a adapter

        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.setHasFixedSize(true)
        recycleview.adapter = adapter


        //postDelay takes a runnable & displayed it on main thread using looper
        Handler(Looper.getMainLooper()).postDelayed( Runnable{


            val p3 = ProgrammingItem(3,"R", "Ruby")
            val p4 = ProgrammingItem(4,"JS", "JavaScript")
            val p5 = ProgrammingItem(5,"P", "php")
            val p6 = ProgrammingItem(6,"P", "python")


            adapter.submitList(listOf(p3,p4,p5,p6))
        }, 4000)
    }
}