package com.example.animalkingdom

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Temperatura : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperatura)



//Crear instancia para hacer el llamado
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//Crear servicio para hacer las llamadas
        val service = retrofit.create<APIService>(APIService::class.java)


        //Para carga la info en la activity
        var temp = findViewById<TextView>(R.id.temp)


        var post : Weather?
        service.getAllPosts().enqueue(object : Callback<Weather> {
            override fun onResponse(
                call: Call<Weather>?, response: Response<Weather>?)  {
                post = response?.body()
                var result = response?.body()?.current_weather?.temperature.toString()
                //Log.i("TAG_LOGS", Gson().toJson(post))
                //Log.d("TEMPERATURA",result)
                temp.text = "Temperatura:  "+result + " grados"


            }

            override fun onFailure(
                call: Call<Weather>?, t: Throwable?) {
                t?.printStackTrace()
                temp.text = "Error - Verifique la conexion a Internet"
            }
        })







    }
}