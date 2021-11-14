package com.example.animalkingdom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    var Usuario = findViewById<EditText>(R.id.txtusuario)
    var Clave = findViewById<EditText>(R.id.txtpassword)

    //Programacion del Boton de Login
    var Boton1 = findViewById<Button>(R.id.Login)
    Boton1.setOnClickListener {
        ingresar(Usuario, Clave)
    }



}



fun ingresar(Usuario: EditText, Clave: EditText) {
    //Tomo el valor de EditExt Usuario
    var convierteUsuario = Usuario.text.toString()
    var convierteClave = Clave.text.toString()

    //Validacion admin
    if (convierteUsuario=="zoo" && convierteClave=="zoo"){


    //Instancio objeto tipo data class
        var pasedatos = dUsuarios(convierteUsuario,convierteClave)

        //Para pasar de la  pantalla(MainActivity) hacia la otra llamada Animales
        val intent = Intent(this,Panel:: class.java)


        //Envio el objeto pasedatos,  bajo el id prueba
        intent.putExtra("usuario",pasedatos)


        //inicia  la pantalla -Panel-
        startActivity(intent)

    } else {

        //Muestra Toast con mensaje de error
        Toast.makeText(this,"Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()

    }


}

}