package com.example.mydiffutilsexample

import androidx.recyclerview.widget.DiffUtil

//Algoritmo y funciones  para comprobar 2 listas distintas para ver cuales son sus cambios y esa es la forma mas optima para descubrir cuales son las posiciones que han sido cambiadas
//Las listas no hay que modificarlas, no hay que crear una lista mutable que se vaya modificando ,hay que crear nuevas intsancias de la lista y trabajar con la propiedad de la inmutabilidad
//programacion funcional

//va a recibir como parametros 2 listados, la lista vieja y una lista nueva
class SuperheroDiffUtil(
    private val oldList: List<Superhero>,
    private val newList: List<Superhero>
):DiffUtil.Callback(){

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}