package com.example.ejercicio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio3.databinding.ActivityRecyclerMainBinding

class recyclerMain : AppCompatActivity() {
    companion object{
        const val alumnoList_KEY = "alumnoList"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val Binding = ActivityRecyclerMainBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        val bundle = intent.extras!!
        val list= intent.getParcelableArrayListExtra<Alumnos>(alumnoList_KEY)

        println(list)

        Binding.alumnoRecycler.layoutManager = LinearLayoutManager(this)

        val adapter = alumnoAdapter()
        Binding.alumnoRecycler.adapter = adapter
        adapter.submitList(list)


    }
}