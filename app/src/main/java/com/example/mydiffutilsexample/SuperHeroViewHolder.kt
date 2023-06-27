package com.example.mydiffutilsexample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//crear funcion render(recibe como parametro el objeto super hero de la data class para pasarsela al viewholder)
class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    //necesitamos acceder a los dos text views de la siguente manera:
    val tvName = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val tvId = view.findViewById<TextView>(R.id.tvId)

    fun render(superhero: Superhero, onItemRemove: (Superhero) -> Unit) {
        tvName.text = superhero.name
        tvId.text = superhero.id
        ///
        tvName.setOnClickListener { onItemRemove(superhero) } //-> pasar aqui la funcion lambda
    }
}