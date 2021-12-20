package com.example.animalkingdom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animalkingdom.databinding.ActivityAbuscadorRazasBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class aBuscadorRazas : AppCompatActivity(), SearchView.OnQueryTextListener,
    android.widget.SearchView.OnQueryTextListener {

    //Para referenciar los elementos directamente desde la activity sin identificacion previa
    private lateinit var binding: ActivityAbuscadorRazasBinding
    private lateinit var adapter: DogAdapter

    //Para iniciar el adapter necesita listado de imagenes, estas varian x cada raza q escriban
    private val dogImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbuscadorRazasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svDogs.setOnQueryTextListener(this)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()

            //URI de la API
            .baseUrl("https://dog.ceo/api/breed/")

            //Conversor de JSON a nuestro modelo de datos (DogsResponse)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Llamada Asincrona, para no bloquear la App Principal - Cuando se hace la consulta a internet
    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body()

            //salgo de la corrutina para que aparezcan las imagenes o el TOAST
            runOnUiThread {
                if(call.isSuccessful){
                    //Operador ELVIS - si es nulo actuara y obtendremos una lista vacia - NULL SAFETY
                    val images = puppies?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    //Notificar que hubo cambios
                    adapter.notifyDataSetChanged()
                }else{
                    //Considerar que a API service puede estar caido
                    showError()
                }

            }

        }
    }

    fun showError(){
        Toast.makeText(this,"Ha ocurrido un Error",Toast.LENGTH_SHORT).show()
    }

    //LISTENERS DEL SEARCHVIEW
    //Cuando presiona enter, o la lupa en el buscar - envio a retrofir para que realize la peticion a internet
    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){

            //pasaje a minusculas - API Protection
            searchByName(query.toLowerCase())
        }
        return true
    }

    //Cada vez que se escribe una letra - NO ES RELEVANTE dado que solo necesitamos que nos avise cuando el usuario haya terminado de escribir
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}