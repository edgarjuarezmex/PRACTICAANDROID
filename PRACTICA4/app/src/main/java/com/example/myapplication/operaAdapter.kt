package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.DiffCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.OperacionesListItemBinding

class operaAdapter: ListAdapter<operacionesDatos, operaAdapter.operaViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<operacionesDatos>() {
        override fun areItemsTheSame(oldItem: operacionesDatos, newItem: operacionesDatos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: operacionesDatos, newItem: operacionesDatos): Boolean {
            return oldItem == newItem
        }
    }


    lateinit var onItemClickListener: (operacionesDatos) -> Unit


    //FORMA CON BINDING IMPLEMENTARLO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): operaAdapter.operaViewHolder {
        val Binding = OperacionesListItemBinding.inflate(LayoutInflater.from(parent.context))
        return operaViewHolder(Binding)
    }

    override fun onBindViewHolder(holder: operaAdapter.operaViewHolder, position: Int) {
        val alumnos = getItem(position)
        holder.bind(alumnos)
    }




    inner class operaViewHolder(private val Binding: OperacionesListItemBinding) :
        RecyclerView.ViewHolder(Binding.root) {
        fun bind(operacionesDatos: operacionesDatos) {
            Binding.operacionTextview.text = operacionesDatos.nombre

            Binding.root.setOnClickListener{
                if (::onItemClickListener.isInitialized){
                    onItemClickListener(operacionesDatos)
                }
            }
            //Muy recomendable al momento de recycler view
            Binding.executePendingBindings()
        }
    }


}