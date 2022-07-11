package br.com.zup.rickandmortyemsimcity.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import br.com.zup.rickandmortyemsimcity.R
import br.com.zup.rickandmortyemsimcity.domain.model.Character

class CharacterAdapter(val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    class CharacterHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivCharacter: ImageView = itemView.findViewById(R.id.ivCharacter)

        private val tvName: TextView = itemView.findViewById(R.id.tvNameCharacter)

        fun setCharacter(character: Character) {
            Picasso.get().load(character.image).into(ivCharacter)
            tvName.text = character.name
            ivCharacter.contentDescription = "imagem " + character.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        val viewHolder = CharacterHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val character = characters[position]
        holder.setCharacter(character)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}
