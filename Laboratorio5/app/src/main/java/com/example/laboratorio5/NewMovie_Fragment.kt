package com.example.laboratorio5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class NewMovie_Fragment : Fragment() {

    private lateinit var btnSubmit : Button

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
    }


    private fun listeners(){
        btnSubmit.setOnClickListener{
            it.findNavController().navigate(R.id.action_newMovie_Fragment_to_bilboard_Fragment)
        }
    }
}