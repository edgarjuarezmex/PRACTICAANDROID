package com.example.ejerciciomulta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejerciciomulta.databinding.ActivityResultadoBinding

class resultado : AppCompatActivity() {
    companion object{
        const val folio_KEY = "folio"
        const val nombre_KEY = "nombre"
        const val resultado_KEY  = "multa"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val Binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        val bundle =intent.extras!!
        Binding.folioTextview.text = bundle.getInt(folio_KEY).toString()
        Binding.nombreTextview.text = bundle.getString(nombre_KEY).toString()
        Binding.salarioTextview.text = bundle.getDouble(resultado_KEY).toString()
    }
}