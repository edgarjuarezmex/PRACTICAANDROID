package com.example.ejerciciomulta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import com.example.ejerciciomulta.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    var nombre:String = ""
    var folio:Int = 0
    var multa:Double = 0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nuevoButton.setOnClickListener{
            binding.folioEdittext.text.clear()
            binding.nombreEdittext.text.clear()
            binding.sueldoMinimoEdittext.text.clear()
        }

        binding.calcularButton.setOnClickListener(){
            multa = binding.sueldoMinimoEdittext.text.toString().toDouble() * .10
        }

        binding.salirButton.setOnClickListener{
            exitProcess(0)
        }
    }


    private fun openResultado(folio:Int,nombre:String,multa:Double){
        val intent = Intent(this,resultado::class.java)

        //FORMA DE PASAR LOS INTENT
        intent.putExtra(resultado.folio_KEY,folio)
        intent.putExtra(resultado.nombre_KEY,nombre)
        intent.putExtra(resultado.resultado_KEY,multa)
    }

}