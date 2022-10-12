package com.example.ejercicio3

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.ejercicio3.databinding.AlumnoListItemBinding

class alumnoAdapter: ListAdapter<Alumnos, alumnoAdapter.alumnoViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Alumnos>() {
        override fun areItemsTheSame(oldItem: Alumnos, newItem: Alumnos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Alumnos, newItem: Alumnos): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClickListener: (Alumnos) -> Unit


    //FORMA CON BINDING IMPLEMENTARLO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): alumnoAdapter.alumnoViewHolder {
        val Binding = AlumnoListItemBinding.inflate(LayoutInflater.from(parent.context))
        return alumnoViewHolder(Binding)
    }

    override fun onBindViewHolder(holder: alumnoAdapter.alumnoViewHolder, position: Int) {
        val alumnos = getItem(position)
        holder.bind(alumnos)
    }


    inner class alumnoViewHolder(private val Binding: AlumnoListItemBinding) :
        RecyclerView.ViewHolder(Binding.root) {
        fun bind(alumnos: Alumnos) {
            Binding.grupoTextview.text= alumnos.grupo
            Binding.nombreTextview.text = alumnos.nombre
            Binding.edadTextview.text = alumnos.edad.toString()


            //Muy recomendable al momento de recycler view
            Binding.executePendingBindings()
        }
    }
}


