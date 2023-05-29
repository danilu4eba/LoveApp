package com.example.loveapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.loveapp.remote.LoveModel

class LoveViewModel : ViewModel() {
    private val repository = Repository()

    fun getLiveLove(firstname: String, secondname: String): LiveData<LoveModel> {
        return repository.getLoveMutableData(firstname, secondname)

    }
}