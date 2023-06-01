package com.example.loveapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.loveapp.data.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    fun getLiveLove(firstname: String, secondname: String): LiveData<LoveModel> {
        return repository.getLoveMutableData(firstname, secondname)

    }
}