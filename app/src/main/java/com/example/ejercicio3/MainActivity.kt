package com.example.ejercicio3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import com.example.ejercicio3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var alumnosList = mutableListOf<Alumnos>()
    var nombre = ""
    var edad = 0
    var grupo = ""
    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.verButton.setOnClickListener(){
            openIntent()
        }

        binding.limpiarButton.setOnClickListener(){
            binding.edadEdittext.text.clear()
            binding.nombreEdittext.text.clear()
            binding.grupoEdittext.text.clear()
        }

        binding.agregarButton.setOnClickListener(){
            nombre = binding.nombreEdittext.text.toString()
            edad = binding.edadEdittext.text.toString().toInt()
            grupo = binding.grupoEdittext.text.toString()
            contador += 1
            agregarAlumno(contador,nombre,edad,grupo)
            binding.edadEdittext.text.clear()
            binding.nombreEdittext.text.clear()
            binding.grupoEdittext.text.clear()
        }

    }



    private fun agregarAlumno(contador:Int,nombre:String, edad:Int, grupo:String){
        alumnosList.add(Alumnos(contador,nombre,edad,grupo))
    }



    private fun openIntent(){
        val alumnoList= ArrayList<Alumnos>(alumnosList)
        val intent = Intent(this,recyclerMain::class.java)
        intent.putParcelableArrayListExtra(recyclerMain.alumnoList_KEY,alumnoList)
        startActivity(intent)
    }

}



