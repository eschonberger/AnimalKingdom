package com.example.animalkingdom


abstract class Animales{

    var nombre: String=""
    var clase: String=""
    var conservacion: String=""

    constructor(nombre:String, clase: String, conservacion:String ){
        this.nombre=nombre
        this.clase=clase
        this.conservacion=conservacion
    }

    //Lo que pueden hacer
    abstract fun cazar()

    abstract fun correr():String

    abstract fun nadar():String


    fun estadoConservacion(estado:String):String{
    var mensaje:String=""
    when (estado) {
        "EX" -> mensaje ="Estado: El ${this.nombre} se encuentra extinto"

        "EW" -> mensaje = "Estado: El ${this.nombre} se encuentra extinto en estado silvestre, cuando los únicos miembros vivos están mantenidos en cautiverio"

        "VU" -> mensaje= "Estado: El ${this.nombre} se encuentra en situacion ${this.conservacion} dado que existe una importante reducción en la población de la especie"

        "LC" -> mensaje = "Estado: El ${this.nombre}  se encuentra en situacion ${this.conservacion} por determinarse que no se encuentra en peligro o amenazado."
    }
        return mensaje
}
}