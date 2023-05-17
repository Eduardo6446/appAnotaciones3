package com.example.anotaciones3.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.anotaciones3.dao.TareasDao
import com.example.anotaciones3.models.Tareas

@Database(
    entities = [Tareas::class],
    version = 1
)
abstract class TareasDb: RoomDatabase() {
    abstract fun tareasDao():TareasDao

}