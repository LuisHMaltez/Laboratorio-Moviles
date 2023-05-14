package com.example.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.laboratorio05.R
import com.example.laboratorio05.data.movies
import com.example.laboratorio05.databinding.ActivityMainBinding
import com.example.laboratorio05.databinding.FragmentBillboardBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentBillboardBinding
    private val movieViewModel: MovieViewModel by activityViewModels<MovieViewModel> {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_billboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MovieAdapter()
        binding.RecycleView.adapter = adapter
        adapter.setData(movies)
        listeners()

    }
    private fun listeners(){

        binding.btnNavCreateNewMovie.setOnClickListener{
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
    }
}