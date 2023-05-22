package com.example.parcial_deportes

import android.app.Application
import com.example.parcial_deportes.data.sports
import com.example.parcial_deportes.repository.SportRepository

class SportReviewerApplication: Application() {
    val sportRepository: SportRepository by lazy {
        SportRepository(sports)
    }
}