package com.example.anotaciones3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anotaciones3.adaptadores.TareasAdapter
import com.example.anotaciones3.config.constantes
import com.example.anotaciones3.databinding.ActivityMainBinding
import com.example.anotaciones3.viewmodel.InsertarViewModel
import com.example.anotaciones3.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel:MainViewModel
    lateinit var viewModel1: InsertarViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //TODO ENLAZAR MODELO LIVEDATA
        viewModel = ViewModelProvider(this).get()
        viewModel.iniciar()

        //PENDIENTES
        binding.rvTareasPendientes.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }
        viewModel.tareasList.observe(this, Observer {
            binding.rvTareasPendientes.adapter = TareasAdapter(it)
        })


        //FINALIZADAS
        binding.rvTareasFinalizadas.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }
        viewModel.tareasList.observe(this, Observer {
            binding.rvTareasFinalizadas.adapter = TareasAdapter(it)
        })

        //AÑADIR
        /*viewModel1.op = intent.getStringExtra(constantes.OPERACION_KEY)!!
        binding.modelo = viewModel1
        binding.lifecycleOwner = this

        viewModel1.op_ex.observe(this,Observer{
            if(it){
                print("")
            }else{
                print("")
            }
        })*/

        viewModel.op_ex.observe(this, Observer {
            if(it){
                mostrarMensaje("EXITO")
            }
            else{
                mostrarMensaje("F")

            }


        })
    }

    private fun mostrarMensaje(s:String){
        Toast.makeText(applicationContext,s,Toast.LENGTH_LONG).show()
    }

    private fun reset(){
        val intent = Intent(applicationContext,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    /*override fun borrar(){
        viewModel.eliminarTarea()
    }*/
}