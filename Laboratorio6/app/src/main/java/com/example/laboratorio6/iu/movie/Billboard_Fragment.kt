package com.example.laboratorio6.iu.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio6.R
import com.example.laboratorio6.data.adapter.MovieAdapter
import com.example.laboratorio6.data.model.movies
import com.example.laboratorio6.repositories.MovieRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass.
 * Use the [Billboard_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Billboard_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var buttonFragmentNewMovie: FloatingActionButton
    private lateinit var recyclerViewMovies: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()

        val repository = MovieRepository(movies)
        val adapter = MovieAdapter()
        adapter.setData(repository.getMovies())

        recyclerViewMovies.adapter = adapter
        recyclerViewMovies.layoutManager = LinearLayoutManager(context)
    }

    private fun bind(){
        //cardViewFragmentStarWars = view?.findViewById(R.id.card_view_star_wars) as CardView
        buttonFragmentNewMovie = view?.findViewById(R.id.btn_link_new_movie) as FloatingActionButton
        recyclerViewMovies = view?.findViewById(R.id.movies_recycle_view) as RecyclerView
    }

    private fun listeners() {
        buttonFragmentNewMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboard_Fragment_to_new_Movie_Fragment)
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Billboard_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Billboard_Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}