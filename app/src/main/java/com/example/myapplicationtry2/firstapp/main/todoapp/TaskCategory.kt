package com.example.myapplicationtry2.firstapp.main.todoapp

sealed class TaskCategory {
    object  Personal :TaskCategory()
    object  Business :TaskCategory()
    object  Other :TaskCategory()
}