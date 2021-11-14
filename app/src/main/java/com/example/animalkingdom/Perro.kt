package com.example.animalkingdom

class Perro(): Animales(nombre ="",clase="",conservacion = "") {

    constructor(nombre:String,clase:String,conservacion:String):this(){
        this.nombre=nombre
        this.clase=clase
        this.conservacion=conservacion
    }


    override fun cazar(){
        print("El ${this.nombre} esta Cazando")

    }

    override fun correr():String{
        return("El ${this.nombre} empezo a correr")
    }

    override fun nadar():String {
        return("El ${this.nombre} esta nadando")

    }
}