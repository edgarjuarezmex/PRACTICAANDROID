package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var numero1 :Int = 0
    var numero2 :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.operacionesButton.setOnClickListener(){
            if (binding.numero1Edittext.text.toString() == "" && binding.numero2Edittext.toString() == "" ){
                Toast.makeText(this,"FAVOR DE AGREGAR ALGUN NUMERO",Toast.LENGTH_SHORT).show()
            }
            else{
                numero1 = binding.numero1Edittext.text.toString().toInt()
                numero2 = binding.numero2Edittext.text.toString().toInt()
                openOperaciones(numero1,numero2)
            }
        }
    }

    private fun openOperaciones(numero1:Int, numero2:Int){
        val intent = Intent(this,operaciones::class.java)
        intent.putExtra(operaciones.numero1_KEY,numero1)
        intent.putExtra(operaciones.numero2_KEY,numero2)
        startActivity(intent)
    }
}