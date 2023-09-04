package com.example.myapplicationtry2.firstapp.main.todoapp

sealed class TaskCategory(var isSelected:Boolean = true){
    object  Personal :TaskCategory()
    object  Business :TaskCategory()
    object  Other :TaskCategory()
}