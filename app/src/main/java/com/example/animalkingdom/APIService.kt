package com.example.animalkingdom

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    //Tipo de llamada
    @GET

    suspend fun getDogsByBreeds(@Url url:String): Response<DogsResponse>


}