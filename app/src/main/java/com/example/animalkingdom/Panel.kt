package com.example.animalkingdom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Panel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

//Recibo el objeto del usuario desde la Main Actity
        val datosusuario: dUsuarios? = intent.getParcelableExtra("usuario")

        //Textview donde se muestran los datos del usuario
        var textologin = findViewById<TextView>(R.id.textView3)

        //Reemplaza el Texto con los datos obtenidos del usuario
        textologin.text = "Usuario: ${datosusuario?.nombreUsuario}"

//Animal 1 - Leon
        //Se crea el objeto animal1 tipo Leon
        var animal1:Leon = Leon("Leon","Mamifero","VU")

        //Localizar Textview donde se mostraran los datos del Leon
        var nombreanimal1 = findViewById<TextView>(R.id.tva1)

        //Muestra el texto con el nombre
        nombreanimal1.text = "Nombre:  ${animal1.nombre}"


        //Textview donde se muestran los datos del estado de conservacion
        var textoconservacion = findViewById<TextView>(R.id.eca1)

        //Muestra el texto recuperado luego de invocar el metodo estadoConservacion
        textoconservacion.text = animal1.estadoConservacion(animal1.conservacion).toString()


        //Programacion del Boton del Primer Animal -> Leon
        var botonLeon = findViewById<Button>(R.id.btna1)
        botonLeon.setOnClickListener {

            //Muestra Toast con el rugido del leon
            Toast.makeText(this,"El Leon hace GRRR", Toast.LENGTH_SHORT).show()

            //Instancio objeto tipo data class Animales
            var paseanimal1 = dAnimales(animal1.nombre,animal1.clase,animal1.conservacion)

            //Para pasar de la  pantalla(Panel) hacia la del Leon
            val intent = Intent(this,ALeon:: class.java)


            //Envio el objeto paseanimal,  bajo el id animal1
            intent.putExtra("animal1",paseanimal1)


            //inicia  la pantalla -Leon-
            startActivity(intent)
        }

//Animal 2 - Perro

        //Se crea el objeto animal2 tipo Perro
        var animal2:Perro = Perro("Perro","Mamifero","LC")

        //Localizar Textview donde se mostraran los datos del Perro
        var nombreanimal2 = findViewById<TextView>(R.id.tva2)

        //Muestra el texto con el nombre
        nombreanimal2.text = "Nombre:  ${animal2.nombre}"


        //Textview donde se muestran los datos del estado de conservacion
        var textoconservacion2 = findViewById<TextView>(R.id.eca2)

        //Muestra el texto recuperado luego de invocar el metodo estadoConservacion
        textoconservacion2.text = animal2.estadoConservacion(animal2.conservacion).toString()


        //Programacion del Boton del Segundo Animal -> Perro
        var botonPerro = findViewById<Button>(R.id.btna2)
        botonPerro.setOnClickListener {

            //Muestra Toast con el sonido del Perro
            Toast.makeText(this,"El Perro hace GUAU", Toast.LENGTH_SHORT).show()

            //Instancio objeto tipo data class Animales
            var paseanimal2 = dAnimales(animal2.nombre,animal2.clase,animal2.conservacion)

            //Para pasar de la  pantalla(Panel) hacia la del Perro
            val intent = Intent(this,aperro:: class.java)


            //Envio el objeto paseanimal2,  bajo el id animal2
            intent.putExtra("animal2",paseanimal2)


            //inicia  la pantalla -Perro-
            startActivity(intent)
        }

        //Programacion del Boton de la Temperatura
        var botonTemp = findViewById<Button>(R.id.btntemp)
        botonTemp.setOnClickListener {
            //Para pasar de la  pantalla(Panel) hacia la de la Temperatura
            val intent = Intent(this,Temperatura:: class.java)

            //inicia  la pantalla -Perro-
            startActivity(intent)
            }
    }
}