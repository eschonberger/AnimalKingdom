package com.example.animalkingdom

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    //Tipo de llamada
    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogsResponse>

    @GET("forecast?latitude=-34.6118&longitude=-58.4173&current_weather=true")
    fun getAllPosts(): Call<Weather>

}