package com.example.ejerciciospractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejerciciospractica.databinding.ActivityMainBinding
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private var usd: Double = 0.00
    private var eur: Double = 0.00
    private var dinero:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.salirButton.setOnClickListener{
            salir()
        }

        binding.convertirButton.setOnClickListener {

            if(binding.ingresarDineroEditText.text.toString() == ""){
                Toast.makeText(this,"FAVOR DE INGRESAR ALGO DE CAMBIO",Toast.LENGTH_LONG).show()
            }
                else {
                dinero = binding.ingresarDineroEditText.text.toString().toDouble()
                convertir()
                binding.resultadoUSDTextview.text = "%.2f".format(usd.toDouble()).toString()
                binding.resultadoEURTextview.text = "%.2f".format(eur.toDouble()).toString()
            }
        }


        //codigo de nuevo button
        binding.nuevoButton.setOnClickListener {
            reset()
            binding.resultadoUSDTextview.text = usd.toString()
            binding.resultadoEURTextview.text = eur.toString()
            binding.ingresarDineroEditText.text = null
        }

    }

    private fun reset(){
        usd =  0.00
        eur =  0.00
        dinero = 0.00
    }

    private fun convertir(){
        usd = dinero * 3.24
        eur = dinero * 3.94
    }

    private fun salir(){
        finish()
        exitProcess(0);
    }
}