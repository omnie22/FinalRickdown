package com.example.rickandmorty.adapter

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
    class RMViewHolder(
        private val binding: RecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

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