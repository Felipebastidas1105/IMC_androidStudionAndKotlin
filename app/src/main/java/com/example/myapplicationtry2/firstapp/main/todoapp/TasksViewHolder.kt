package com.example.myapplicationtry2.firstapp.main.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationtry2.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private var tvTask:TextView = view.findViewById(R.id.tvTask)
    private var checkboxTask:CheckBox = view.findViewById(R.id.checkboxTask)
    fun render(task:Task){

        if (task.isSelected){
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        checkboxTask.isChecked = task.isSelected

       val color =  when(task.category){
            TaskCategory.Business -> R.color.todo_business_category
            TaskCategory.Other -> R.color.todo_other_category
            TaskCategory.Personal -> R.color.todo_personal_category
        }

        checkboxTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(checkboxTask.context,color)
        )

        tvTask.text = task.name
    }
}