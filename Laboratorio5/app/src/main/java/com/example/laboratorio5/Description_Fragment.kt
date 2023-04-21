package com.example.laboratorio5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class Description_Fragment : Fragment() {

    private lateinit var btnReturn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()
    }

    private fun bind(){
        btnReturn = view?.findViewById(R.id.return_btn) as Button
    }


    private fun listeners(){
        btnReturn.setOnClickListener{
            it.findNavController().navigate(R.id.action_description_Fragment_to_bilboard_Fragment)
        }
    }
}
