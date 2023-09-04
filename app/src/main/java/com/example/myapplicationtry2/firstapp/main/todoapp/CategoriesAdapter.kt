package com.example.myapplicationtry2.firstapp.main.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationtry2.R

class CategoriesAdapter (private val categories:List<TaskCategory>, private val onItemSelected:(Int)-> Unit): RecyclerView.Adapter<CategoriesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder { //Este metodo crearia una vista visual y montar la vista
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category,parent,false) //Se crea un inflador de vistas y necesita un contexto y ese se puede sacar de cualquier componente
        return  CategoriesViewHolder(view)
    }
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) { //Pasa la informacion de que tiene que pintar
        holder.render(categories[position],onItemSelected)
    }

    override fun getItemCount() =  categories.size

}