package com.example.laboratorio05.ui.movie


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private var qualificationTextView: TextView = itemView.findViewById(R.id.qualificationTextView)
    private var imageView: ImageView = itemView.findViewById(R.id.imageView)

    fun bind(movie: MovieModel){
        nameTextView.text = movie.name
        qualificationTextView.text = movie.qualification
    }

}

