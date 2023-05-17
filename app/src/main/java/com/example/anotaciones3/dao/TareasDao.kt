package com.example.anotaciones3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.anotaciones3.models.Tareas

@Dao
interface TareasDao {

    @Query("SELECT * FROM Tareas")
    suspend fun getAll():List<Tareas>

    @Query("SELECT * From Tareas WHERE Finalizado = 'true'")
    suspend fun getFinished():List<Tareas>

    @Query("SELECT * From Tareas WHERE Finalizado = 'false'")
    suspend fun getPendientes():List<Tareas>


    @Insert
    suspend fun insert(tareas:List<Tareas>):List<Long>

    @Update
    suspend fun update(tareas:Tareas):Int

    @Delete
    suspend fun delete(tareas:Tareas):Int

}