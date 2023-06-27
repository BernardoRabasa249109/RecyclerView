package com.example.mydiffutilsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //creando al SuperHero adapter desde aqui

    private var superheroes = listOf(
            Superhero("BernaMan", "1", "cursokotlin.com"),
            Superhero("KotlinMan", "2", "cursokotlin.com"),
            Superhero("FlutterCry", "3", "cursokotlin.com")
    )


    lateinit var superheroAdapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        crear instancia o acceder a la vista de un recycler view
        val rv = findViewById<RecyclerView>(R.id.rvExample)
        //LLamando al boton
        val btnAddSuperhero = findViewById<Button>(R.id.btnAddSuperHero)

        //Creando la funcion del boton que hicimos en el activity main, cada vez que lo pulce creare un nuevo super heroe, pero que no sea el mismo de mi lista
        btnAddSuperhero.setOnClickListener {
            val random = Random.nextInt(10000).toString() //-> Rango entre 0 y 10000 para los ids randoms
            val superhero = Superhero("FlutterCry $random" , random, "cursokotlin.com")
            superheroes = superheroes.plus(superhero) //-> cambiando el add por el plus, por que no le puedes añadir a valores a  una lista que no puede mutar
            //avisando al adapter del cambio
            //superheroAdapter.notifyDataSetChanged()->es como decirle la lista ha cambiado remplazala entera, esto no es lo optimo por que remplazas la lista completa contantemente, si solo cambio un valor por que voy a remplazar toda la lista?
            //superheroAdapter.notifyItemInserted() //que posision cambio? o si viene un listado nuevo de back end como saber los items que cambiaron ?
            superheroAdapter.updateList(superheroes)
        }
        //creando adapter
        superheroAdapter = SuperHeroAdapter(superheroes){
            //superheroes.remove(it) ->it es el item seleccionado
            superheroes = superheroes.minus(it)
            superheroAdapter.updateList(superheroes)
        //superheroAdapter.notifyDataSetChanged()-> esto funciona perooooo no es optimo
        }//-> pasar aqui la funcion lambda

        //Configurar el recyclerview y acceder a todas sus propiedades con apply
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = superheroAdapter
        }
    }
}


//Pasos para mejorar un RecyclerView con DiffUtil y id para acceder a esa vista
//1. Crear en un layout un recyclerview
//2. En en main activity crear una instancia para acceder a esa vista
//3. Que va a pintar my RecyclerView? creando una data clas que es una clase para manejo de datos llamada "Superhero" de alli obtendra los datos a pintar(mi adapter)
//4. Montar un adapter que es mi clase "superhero" y luego mi clase viewHolder "SuperHeroViewHolder" básicos (para pintar cosas en un recyclerview necesitamos un adapter
//5. Crear una clase llamada "superHeroAdapter" que es mi viewHolder
//6. una ves creada el viewholder hay que pasarle por parametros ((view:View):RecyclerView.ViewHolder(view) e implementar el RecyclerView)
//7. Añadir o borrar un item? lo solemos hacer de una manera no muy eficiente
//8. al picar un boton ire añadiendo un nuevo super heroe, lo creamos en el activity main.xml
//en este punto se ejectuto la app pero no se pinto nada en la pantalla por que hay que avisar al adapter que hubo cambios en el listado que esta pintando
//Borrar items en el adapter con funciones lambda
//en lugar de llamar a los notifyDataChange , crear metodo en el adapter
