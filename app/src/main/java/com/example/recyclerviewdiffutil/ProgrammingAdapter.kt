package com.example.recyclerviewdiffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProgrammingAdapter : ListAdapter<ProgrammingItem,ProgrammingAdapter.ProgrammingViewHolder>(Diffutil()) {

    class ProgrammingViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.nameTextView)
        val initial = view.findViewById<TextView>(R.id.initialTextView)

        fun bind(item: ProgrammingItem){
            name.text = item.name
            initial.text = item.initial
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_views, parent , false)

        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {

        val item = getItem(position)
        holder.bind(item)

    }

    //Normal adapter me size method hota h


    class Diffutil :  DiffUtil.ItemCallback<ProgrammingItem>() {
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {

            return oldItem.id == newItem.id
        }

        // It will check the content are same or not
        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {

           return oldItem == newItem
        }


    }
}