package com.example.animalkingdom

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.animalkingdom.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder(view: View):RecyclerView.ViewHolder(view){
    private val binding = ItemDogBinding.bind(view)

    //Para transformar las url en Imagenes con picasso
    //sera consumida desde el adapter, enviando una URL en formato String
    fun bind (image:String){
        Picasso.get().load(image).into(binding.ivDog)

    }
}