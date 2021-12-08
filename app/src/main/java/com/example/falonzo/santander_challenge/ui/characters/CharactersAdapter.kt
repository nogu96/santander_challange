package com.example.falonzo.santander_challenge.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.falonzo.santander_challenge.databinding.CharacterItemBinding
import com.example.falonzo.santander_challenge.extension.load
import com.example.falonzo.santander_challenge.model.Character

class CharactersAdapter(): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private val characterList: MutableList<Character> = mutableListOf()
    private var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            listener,
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList.get(position))
    }

    override fun getItemCount() = characterList.size

    interface Listener {
        fun onSelect(character: Character)
    }

    fun set(listener: Listener) {
        this.listener = listener
    }

    fun upload(upload: List<Character>) {
        characterList.addAll(upload)
        notifyDataSetChanged()
    }

    class ViewHolder(
        val listener: Listener?,
        val binding: CharacterItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.imageView.load(character.thumbnail.getUrl())
            binding.txtTitle.text = character.name

            binding.root.setOnClickListener {
                listener?.onSelect(character)
            }
        }
    }

}