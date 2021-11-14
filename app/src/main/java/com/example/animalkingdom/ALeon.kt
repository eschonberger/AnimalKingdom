package com.example.animalkingdom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ALeon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aleon)

        //Recibo el objeto desde el Panel - Permite Acceder a los datos del Leon
        val datosanimal1: dAnimales? = intent.getParcelableExtra("animal1")


        //Textview donde se muestran el nombre  del Leon
        var nombreanimal1 = findViewById<TextView>(R.id.na1)

        //Reemplaza el Texto con los datos obtenidos del usuario
        nombreanimal1.text = "Nombre: ${datosanimal1?.nombre}"

        //Textview donde se muestran la clase  al que pertenece  el Leon
        var claseanimal1 = findViewById<TextView>(R.id.ca1)

        //Reemplaza el Texto con los datos del Reino
        claseanimal1.text = "Clase: ${datosanimal1?.clase}"

        //Textview donde se muestran el estado de conservacion al que pertenece  el Leon
        var conservacionanimal1 = findViewById<TextView>(R.id.cona1)

        //Reemplaza el Texto con los datos del Reino
        conservacionanimal1.text = "Conservacion: ${datosanimal1?.conservacion}"


    }
}