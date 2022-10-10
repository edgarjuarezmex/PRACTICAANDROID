package com.example.ejerciciospractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejerciciospractica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var USD: Double = 0.00
    private var EUR: Double = 0.00
    private var dinero:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.convertirButton.setOnClickListener {
            if (USD == 0.00){
                Toast.makeText(this,"FAVOR DE PRESIONAR BOTON NUEVO",Toast.LENGTH_LONG).show()
            }
            else {
                dinero = binding.ingresarDineroEditText.text.toString().toDouble()
                convertir()
                binding.USDTextView.text = USD.toString()
                binding.eurTextview.text = EUR.toString()
            }
        }


        //codigo de nuevo button
        binding.nuevoButton.setOnClickListener {
            reset()
            binding.resultadoUSDTextview.text = USD.toString()
            binding.resultadoEURTextview.text = EUR.toString()
            binding.ingresarDineroEditText.text = null
        }

    }

    private fun reset(){
        USD =  0.00
        EUR =  0.00
        dinero = 0.00
    }

    private fun convertir(){
        USD =  dinero * 3.24
        EUR = dinero * 3.94
    }
}