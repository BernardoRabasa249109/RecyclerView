package com.example.mydiffutilsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //creando al SuperHero adapter desde aqui
    lateinit var superheroAdapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        crear instancia o acceder a la vista de un recycler view
        val rv = findViewById<RecyclerView>(R.id.rvExample)
        //creando adapter
        superheroAdapter = SuperHeroAdapter(
            listOf(
                Superhero("BernaMan", "1", "cursokotlin.com"),
                Superhero("KotlinMan", "2", "cursokotlin.com"),
                Superhero("FlutterCry", "3", "cursokotlin.com")
            )
        )

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
