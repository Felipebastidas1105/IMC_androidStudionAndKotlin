package com.example.myapplicationtry2.firstapp.main.todoapp

data class Task (val name:String,val category:TaskCategory, var isSelected:Boolean = false)