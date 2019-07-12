package com.example.bmiapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewAdapter(private val list: List<RecordData>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.bmi1item, parent, false)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dateView.text = list[position].date.toString()
        holder.heightView.text = list[position].height
        holder.weightView.text = list[position].weight
        holder.bmiView.text = list[position].bmi
    }

    override fun getItemCount(): Int {
        return list.size
    }
}