package com.example.animalkingdom

import com.google.gson.annotations.SerializedName

data class DogsResponse(
    @SerializedName("status") var status: String,
    @SerializedName("message") var images:List<String>
    )


/*
ESTRUCTURA JSON
{
    "message": "https://images.dog.ceo/breeds/african/n02116738_8734.jpg",
    "status": "success"
}
    Estoy diciendo que el parametro message lo estoy llamando images
*/
