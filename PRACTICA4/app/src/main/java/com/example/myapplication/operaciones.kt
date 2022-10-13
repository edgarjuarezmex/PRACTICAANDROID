package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityOperacionesBinding

class operaciones : AppCompatActivity() {
    companion object{
        const val numero1_KEY = "numero1"
        const val numero2_KEY = "numero2"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val Binding = ActivityOperacionesBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        val bundle = intent.extras!!
        var numero1 = bundle.getBundle(numero1_KEY)
        var numero2 = bundle.getBundle(numero2_KEY)

        var list = mutableListOf<operacionesDatos>()
        list.add(operacionesDatos(1,"SUMAR"))
        list.add(operacionesDatos(2,"RESTA"))
        list.add(operacionesDatos(3,"MULTIPLICACION"))
        list.add(operacionesDatos(4,"DIVISION"))


        Binding.operacionesRecycler.layoutManager = LinearLayoutManager(this)


        val adapter = operaAdapter()
        Binding.operacionesRecycler.adapter = adapter
        adapter.submitList(list)

        adapter.onItemClickListener = {
            openActivity(numero1,numero2)
        }


    }

    private fun openActivity(numero1: Bundle?, numero2: Bundle?){
        val intent = Intent(this,resultado::class.java)
        intent.putExtra(resultado.numero1_KEY,numero1)
        intent.putExtra(resultado.numero2_KEY,numero2)
        startActivity(intent)
    }
}