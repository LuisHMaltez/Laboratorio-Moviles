package com.example.laboratorio5.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.laboratorio5.R
import com.example.laboratorio5.data.category
import com.example.laboratorio5.data.model.MovieModel
import com.example.laboratorio5.data.movies
import com.example.laboratorio5.repositories.MovieRepository

class NewMovie_Fragment : Fragment() {

    private lateinit var btnSubmit : Button
    private lateinit var editTextName : EditText
    private lateinit var editTextCategory : EditText
    private lateinit var editTextDescription : EditText
    private lateinit var editTextQualification : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()
    }

    private fun bind(){
        btnSubmit = view?.findViewById(R.id.submit_btn) as Button
        editTextName = view?.findViewById(R.id.edit_text_name) as EditText
        editTextCategory = view?.findViewById(R.id.edit_text_category) as EditText
        editTextDescription = view?.findViewById(R.id.edit_text_description) as EditText
        editTextQualification = view?.findViewById(R.id.edit_text_calification) as EditText

    }


    private fun listeners(){
        btnSubmit.setOnClickListener{
            if(!safeNullData()){
                saveData()
                it.findNavController().navigate(R.id.action_newMovie_Fragment_to_bilboard_Fragment);
            }
        }
    }

    private fun safeNullData(): Boolean{
        return when{
            editTextName.text.isEmpty() -> true
            editTextCategory.text.isEmpty() -> true
            editTextDescription.text.isEmpty() -> true
            editTextQualification.text.isEmpty() -> true
            else -> false
        }
    }

    private fun saveData(){
        val newMovie = MovieModel(
            editTextName.text.toString(),
            editTextCategory.text.toString(),
            editTextDescription.text.toString(),
            editTextQualification.text.toString()
        )

        MovieRepository(movies).addMovies(newMovie)
    }

}