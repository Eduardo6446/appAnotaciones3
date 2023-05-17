package com.example.anotaciones3.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anotaciones3.MainActivity
import com.example.anotaciones3.config.TareasApp
import com.example.anotaciones3.config.TareasApp.Companion.db
import com.example.anotaciones3.config.constantes
import com.example.anotaciones3.models.Tareas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale


class MainViewModel:ViewModel() {
    val tareasList= MutableLiveData<List<Tareas>>()
    var parametroBusqueda = MutableLiveData<String>()
    var id = MutableLiveData<Long>()
    var tarea = MutableLiveData<String>()
    var fin = MutableLiveData<Boolean>()
    var op = constantes.OPERACION_INSERTAR
    var op_ex = MutableLiveData<Boolean>()

    init {
        fin.value = false
    }


    fun iniciar(){
        viewModelScope.launch {
            tareasList.value = withContext(Dispatchers.IO){
                db.tareasDao().getAll()
            }
        }
    }

    fun guardarTarea(){
        val tarea = Tareas(0, tarea.value!!,false)
        when(op){
            constantes.OPERACION_INSERTAR->{
                Log.d("mensaje","INSERTADO")

                viewModelScope.launch{
                    val result = withContext(Dispatchers.IO){
                        db.tareasDao().insert(arrayListOf<Tareas>(tarea))
                    }

                    op_ex.value = result.isNotEmpty()

                }
            }
        }
    }

    fun eliminarTarea(){
        var mTarea = Tareas(id.value!!,"",true)
        viewModelScope.launch {
            var result = withContext(Dispatchers.IO){
                db.tareasDao().delete(mTarea)
            }
            op_ex.value = (result>0)
        }

    }



    /*fun iniciar2(){
        viewModelScope.launch {
            tareasList.value = withContext(Dispatchers.IO){
                *//*db.tareasDao().insert(arrayListOf<Tareas>(
                    Tareas(0, "Primer tarea", true),
                    Tareas(0, "Segunda tarea", false)
                ))*//*
                db.tareasDao().getPendientes()
            }
        }
    }*/


}