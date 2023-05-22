package com.example.parcial_deportes.repository

import com.example.parcial_deportes.data.model.SportModel

class SportRepository (private val sports: MutableList<SportModel>){

    //Get Sport List
    fun getSports() = sports

    //Add Sport to List
    fun addSports(sport: SportModel) = sports.add(sport)
}