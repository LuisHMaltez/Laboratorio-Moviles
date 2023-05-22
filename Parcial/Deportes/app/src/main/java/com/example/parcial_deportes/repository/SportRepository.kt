package com.example.parcial_deportes.repository

import com.example.parcial_deportes.data.model.SportModel

class SportRepository (private val sports: MutableList<SportModel>){

    fun getSports() = sports

    fun addSports(sport: SportModel) = sports.add(sport)
}