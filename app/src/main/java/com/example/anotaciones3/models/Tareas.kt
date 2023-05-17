package com.example.anotaciones3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tareas (
    @PrimaryKey(autoGenerate = true) val id:Long,
    @ColumnInfo(name="tarea") val tarea:String,
    @ColumnInfo(name="Finalizado") val Finalizado:Boolean
    )