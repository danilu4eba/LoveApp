package com.example.loveapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.loveapp.remote.LoveModel
import com.example.loveapp.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    fun getLoveMutableData( firstname: String, secondname:String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        RetrofitService().api.getPercentage(firstname, secondname).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
               liveData.postValue(response.body())

            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("koko", "onFailure: ${t.message}", )
            }

        })

        return liveData
    }
}
