package com.example.animalkingdom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//recibirá un listado de imágenes (las fotos de los perros).
class DogAdapter (val images:List<String>):RecyclerView.Adapter<DogViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
         val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.item_dog,parent,false))

    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item:String = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return images.size
    }

}