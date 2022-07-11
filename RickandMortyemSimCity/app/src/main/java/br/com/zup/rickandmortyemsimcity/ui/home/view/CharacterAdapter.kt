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
        val context = holder.itemView.context

        val cv: CardView = holder.itemView.findViewById(R.id.cvItem)
        cv.setOnClickListener {
            clickCharacter(character, context)
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}


private fun clickCharacter(character: Character, context: Context) {
    val intent = Intent(context, DetailActivity::class.java)
    intent.putExtra("CHARACTER", character)
    context.startActivity(intent)
}

