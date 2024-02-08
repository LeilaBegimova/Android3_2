package com.example.android3_2.ui.adapter

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.android3_2.databinding.ItemBinding
import android.view.ViewGroup as ViewGroup
import com.example.android3_2.data.models.Character


class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharapterViewHolder>() {
    private var charapterList = mutableListOf<Character>()

    fun setCharapter(charapterList: List<Character>) {
        this.charapterList = charapterList.toMutableList()
        notifyDataSetChanged()
    }

    inner class CharapterViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(character: Character) {
            binding.teItem.setImageResource(character.image)
            binding.tvItem.text = character.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharapterViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharapterViewHolder(binding)
    }

    override fun getItemCount() = charapterList.size

    override fun onBindViewHolder(holder: CharapterViewHolder, position: Int) {
        holder.onBind(charapterList[position])
    }
}