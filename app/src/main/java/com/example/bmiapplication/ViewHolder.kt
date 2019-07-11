package com.example.bmiapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val dateView: TextView = itemView.findViewById(R.id.date_data)
    val heightView: TextView = itemView.findViewById(R.id.height_data)
    val weightView: TextView = itemView.findViewById(R.id.weight_data)
    val bmiView: TextView = itemView.findViewById(R.id.bmi_data)
}