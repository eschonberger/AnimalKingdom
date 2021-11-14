package com.example.animalkingdom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class aperro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aperro)


        //Recibo el objeto desde el Panel - Permite Acceder a los datos del Perro
        val datosanimal2: dAnimales? = intent.getParcelableExtra("animal2")


        //Textview donde se muestran el nombre  del Perro
        var nombreanimal2 = findViewById<TextView>(R.id.na)

        //Reemplaza el Texto con los datos obtenidos del Perro
        nombreanimal2.text = "Nombre: ${datosanimal2?.nombre}"

        //Textview donde se muestran la clase  al que pertenece  el Perro
        var claseanimal2 = findViewById<TextView>(R.id.ca)

        //Reemplaza el Texto con los datos del Reino
        claseanimal2.text = "Clase: ${datosanimal2?.clase}"

        //Textview donde se muestran el estado de conservacion al que pertenece  el Perro
        var conservacionanimal2 = findViewById<TextView>(R.id.cona)

        //Reemplaza el Texto con los datos del Reino
        conservacionanimal2.text = "Conservacion: ${datosanimal2?.conservacion}"


        //Programacion del Boton que lleva a la API
        var botonAPI = findViewById<Button>(R.id.btnapi)
        botonAPI.setOnClickListener {

            //Muestra Toast con el sonido del Perro
            Toast.makeText(this,"Ingresa el nombre de la raza a Buscar", Toast.LENGTH_SHORT).show()

            //Para pasar de la  pantalla(Perro) hacia la API que permite buscar por raza
            val intent = Intent(this,aBuscadorRazas:: class.java)

            //inicia  la pantalla -de la API-
            startActivity(intent)
        }


    }
}