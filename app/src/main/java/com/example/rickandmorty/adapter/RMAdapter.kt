package com.example.rickandmorty.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.RecyclerItemBinding
import com.example.rickandmorty.model.RMCharacter

class RMAdapter : RecyclerView.Adapter<RMAdapter.RMViewHolder>() {
    private val characters = mutableListOf<RMCharacter>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RMViewHolder {
        return RMViewHolder.getInstance(parent)
    }
    override fun onBindViewHolder(holder: RMViewHolder, position: Int) {
        characters[position].let { holder.loadName(characters[position]) }
    }
    override fun getItemCount(): Int {
        return characters.size
    }
    fun updateChars(chars: List<RMCharacter>){
        val size = this.characters.size
        this.characters.clear()
        notifyItemRangeRemoved(0,size)
        this.characters.addAll(characters)
        notifyItemRangeInserted(0, chars.size)
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