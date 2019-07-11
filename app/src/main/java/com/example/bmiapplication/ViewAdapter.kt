package com.example.bmiapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewAdapter(private val list: List<RecordData>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val recordView: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_record, parent, false)
        return ViewHolder(recordView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.heightView.text = list[position].height
        holder.weightView.text = list[position].weight
    }

    override fun getItemCount(): Int {
        return list.size
    }
}