package com.example.parcial_deportes.ui.sport

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_deportes.R
import com.example.parcial_deportes.data.model.SportModel

class SportAdapter: RecyclerView.Adapter<SportViewHolder>() {
    private var data: List<SportModel>? = null

    fun setData(data: List<SportModel>?){
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_sport, parent, false)
        return SportViewHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        data?.let {
            val sport = it[position]
            holder.bind(sport)
        }
    }
}