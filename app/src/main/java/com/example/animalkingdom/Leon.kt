package com.example.animalkingdom

import android.widget.Toast

class Leon():Animales(nombre ="",clase="",conservacion = "") {

    constructor(nombre:String,clase:String,conservacion:String):this(){
        this.nombre=nombre
        this.clase=clase
        this.conservacion=conservacion
    }


    override fun cazar(){
        print("El Leon esta Cazando")

    }

    override fun correr():String{
        return("El Leon empezo a correr")
    }

    override fun nadar():String {
        return("Ups los leones no pueden nadar")

    }


}
