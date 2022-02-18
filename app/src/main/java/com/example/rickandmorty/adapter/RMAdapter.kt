package com.example.rickandmorty.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.RecyclerItemBinding
import com.example.rickandmorty.model.RMCharacter

class RMAdapter(chars: List<RMCharacter> ?= null) : RecyclerView.Adapter<RMAdapter.RMViewHolder>() {
    private val characters = chars ?: mutableListOf<RMCharacter>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RMViewHolder {
        return RMViewHolder.getInstance(parent)
    }
    override fun onBindViewHolder(holder: RMViewHolder, position: Int) {
        characters[position].let { holder.loadName(characters[position]) }
    }
    override fun getItemCount(): Int {
        return characters.size
    }

    class RMViewHolder(
        private val binding: RecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun loadName(person: RMCharacter) = with(binding){
            Log.d("ungabunga", "loadName: ")
            putithere.text = person.name
        }
        companion object {
            fun getInstance(parent: ViewGroup): RMViewHolder {
                Log.d("get", "getInstance: ")
                val binding = RecyclerItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return RMViewHolder(binding)
            }
        }
    }
}