package com.example.parcial_deportes.ui.sport

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_deportes.R
import com.example.parcial_deportes.data.model.SportModel

//Preview Of Items
class SportViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private var imageView: ImageView = itemView.findViewById(R.id.imageView)

    fun bind(sport: SportModel){
        nameTextView.text = sport.name
    }
}