package com.example.projectapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface get
{
    @GET("cast")
    fun getdata (): Call<List<DataClass>>
}

class retrofitImage{
    companion object{

        var myimage = Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/shows/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(get::class.java)
    }
}