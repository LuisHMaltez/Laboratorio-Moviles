package com.example.laboratorio5.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.laboratorio5.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Billboard_Fragment : Fragment() {

    private lateinit var buttonFragmentNewMovie: FloatingActionButton
    private lateinit var cardViewFragmentStarWars: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()
    }

    private fun bind(){
        cardViewFragmentStarWars = view?.findViewById(R.id.card_view_star_wars) as CardView
        buttonFragmentNewMovie = view?.findViewById(R.id.new_movie_bnt) as FloatingActionButton
    }

    private fun listeners(){
        buttonFragmentNewMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_bilboard_Fragment_to_newMovie_Fragment)
        }

        cardViewFragmentStarWars.setOnClickListener{
            it.findNavController().navigate(R.id.action_bilboard_Fragment_to_description_Fragment)
        }
    }


}