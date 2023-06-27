package com.example.mydiffutilsexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

//en los parentesis recibirá un listado de mi data class superhero : luego implementar el view holder y en los <va el viewHolder>
class SuperHeroAdapter(private var list: List<Superhero>, val onItemRemove:(Superhero) -> Unit) : //->Funcion lambda
    RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun updateList(newList: List<Superhero>){
        val superheroDiff = SuperheroDiffUtil(list, newList)
        val result = DiffUtil.calculateDiff(superheroDiff)
        list = newList
        result.dispatchUpdatesTo(this)
    }


    //Este metodo crea la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    //Este metodo cuenta el tamaño de mi lita
    override fun getItemCount() = list.size

    //Este metodo es pintar con los datos que te mando,
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.render(list[position], onItemRemove)
    }

}

//Implementar metodos de Adapter que son: onCreateViewHolder, getItemCount, onBindViewHolder


//En Android, un ViewHolder es una clase utilizada en el patrón de diseño del Adapter en
//la programación de interfaces de usuario. Su propósito principal es almacenar las
//referencias a los elementos visuales de un elemento de la lista (como un elemento de
//RecyclerView o un elemento de ListView) para una representación eficiente de la
//interfaz de usuario.

//En resumen, un ViewHolder en Android es una clase utilizada en el patrón del Adapter
//para almacenar y acceder eficientemente a los elementos visuales de cada elemento de
//la lista. Ayuda a mejorar el rendimiento al reciclar vistas en lugar de crear nuevas
//vistas en cada actualización de la lista.