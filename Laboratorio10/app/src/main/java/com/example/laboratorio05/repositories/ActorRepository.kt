package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.dao.ActorDao
import com.example.laboratorio05.data.model.ActorModel


class ActorRepository(private val actorDao: ActorDao) {
        //complete Actor ActorRepository

    //complete getActors method
    suspend fun getAllActors() = actorDao.getAllActors()

    //complete addMovies method
    suspend fun addActors(actor: ActorModel) = actorDao.insertActor(actor)
}