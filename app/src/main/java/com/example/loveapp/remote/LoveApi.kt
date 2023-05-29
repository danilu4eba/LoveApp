package com.example.loveapp.remote

import com.example.loveapp.remote.LoveModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface LoveApi {
  @GET("getPercentage")
    fun getPercentage(
      @Query("fname") first:String,
      @Query("sname") second:String,
      @Header("X-RapidAPI-Key") key:String = "36d83fea66msh32497ff651951d1p170c4cjsn775fa9de778b",
      @Header("X-RapidAPI-Host") host:String = "love-calculator.p.rapidapi.com"
  ):  retrofit2.Call<LoveModel>
}


