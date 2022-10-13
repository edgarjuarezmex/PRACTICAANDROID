package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityResultadoBinding

class resultado : AppCompatActivity() {
    companion object{
        const val numero1_KEY = "numero1"
        const val numero2_KEY = "numero2"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val numero1 = bundle.getBundle(numero1_KEY)
        val numero2 = bundle.getBundle(numero2_KEY)

        var resultado = numero1.toString().toInt()

        binding.resultadoTextview.text = resultado.toString()
    }
}