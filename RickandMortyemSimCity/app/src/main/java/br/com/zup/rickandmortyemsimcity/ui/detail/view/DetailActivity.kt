package br.com.zup.rickandmortyemsimcity.ui.detail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.rickandmortyemsimcity.R
import br.com.zup.rickandmortyemsimcity.R.*
import br.com.zup.rickandmortyemsimcity.databinding.ActivityDetailBinding
import br.com.zup.rickandmortyemsimcity.domain.model.Character
import com.squareup.picasso.Picasso
import android.view.MenuItem

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var character: Character
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pegarDados()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun pegarDados() {
        val data = intent.getParcelableExtra<Character>("CHARACTER")
        if (data != null) {
            character = data
            character.let {
                binding.tvGender.text = "Genero: " + it.gender
                binding.tvName.text = "Nome: " + it.name
                binding.tvSpecies.text = "Specie: " + it.species
                binding.tvStatus.text = "Status: " + it.status
                Picasso.get().load(it.image).into(binding.ivDetail)
                supportActionBar?.title = it.name
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}