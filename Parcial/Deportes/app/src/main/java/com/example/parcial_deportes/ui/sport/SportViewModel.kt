package com.example.parcial_deportes.ui.sport

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial_deportes.SportReviewerApplication
import com.example.parcial_deportes.data.model.SportModel
import com.example.parcial_deportes.repository.SportRepository

class SportViewModel(private val repository: SportRepository): ViewModel(){

    var name = MutableLiveData("")
    var rules = MutableLiveData("")
    var status = MutableLiveData("")

    fun getSports() = repository.getSports()

    fun addSports(sport: SportModel) = repository.addSports(sport)

    fun createSport() {
        if (!validData()){
            status.value = WRONG_INFORMATION
            return
        }
        val sport = SportModel(
            name.value!!,
            rules.value!!
        )

        addSports(sport)
        clearData()

        status.value = SPORT_CREATED
    }

    private fun validData(): Boolean{
        when{
            name.value.isNullOrBlank() -> return false
            rules.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearData(){
        status.value = INACTIVE
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as SportReviewerApplication
                SportViewModel(app.sportRepository)
            }
        }

        const val SPORT_CREATED = "Sport created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}