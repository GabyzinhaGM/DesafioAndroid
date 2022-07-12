package br.com.zup.rickandmortyemsimcity.ui.home.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import  br.com.zup.rickandmortyemsimcity.databinding.ItemCharacterBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import br.com.zup.rickandmortyemsimcity.R
import br.com.zup.rickandmortyemsimcity.domain.model.Character
import br.com.zup.rickandmortyemsimcity.ui.detail.view.DetailActivity

class CharacterAdapter(
    var characters: MutableList<Character>,
    val clik: (character: Character) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    class CharacterHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun setCharacter(character: Character) {
            Picasso.get().load(character.image).into(binding.ivCharacter)
            binding.tvNameCharacter.text = character.name
            binding.ivCharacter.contentDescription = "imagem " + character.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CharacterHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val character = characters[position]

        holder.setCharacter(character)
        holder.binding.cvItem.setOnClickListener {
            clik(character)
        }

    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun updateList(newlist: MutableList<Character>) {
        characters = newlist
        notifyDataSetChanged()
    }
}



