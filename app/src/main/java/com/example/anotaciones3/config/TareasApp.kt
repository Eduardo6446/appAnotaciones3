package com.example.anotaciones3.config

import android.app.Application
import androidx.room.Room
import com.example.anotaciones3.dao.TareasDao

class TareasApp:Application() {
    companion object{
        lateinit var db:TareasDb

    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            TareasDb::class.java,
            "tareas"
        ).build()

    }
}