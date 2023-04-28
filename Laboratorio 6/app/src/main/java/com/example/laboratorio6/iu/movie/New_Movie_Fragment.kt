package com.example.laboratorio6.iu.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.laboratorio6.R
import com.example.laboratorio6.data.model.MovieModel
import com.example.laboratorio6.data.model.movies
import com.example.laboratorio6.repositories.MovieRepository

/**
 * A simple [Fragment] subclass.
 * Use the [New_Movie_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class New_Movie_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var btnSubmit : Button
    private lateinit var editTextName : EditText
    private lateinit var editTextCategory : EditText
    private lateinit var editTextDescription : EditText
    private lateinit var editTextQualification : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new__movie_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()
    }

    private fun bind(){
        btnSubmit = view?.findViewById(R.id.btn_submit) as Button
        editTextName = view?.findViewById(R.id.edit_text_name) as EditText
        editTextCategory = view?.findViewById(R.id.edit_text_category) as EditText
        editTextDescription = view?.findViewById(R.id.edit_text_description) as EditText
        editTextQualification = view?.findViewById(R.id.edit_text_calification) as EditText
    }

    private fun listeners(){

        btnSubmit.setOnClickListener{
            if(!safeNullData()){
                saveData()
                it.findNavController().navigate(R.id.action_new_Movie_Fragment_to_billboard_Fragment);
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment New_Movie_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            New_Movie_Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}