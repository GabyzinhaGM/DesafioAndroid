package br.com.zup.rickandmortyemsimcity.ui.home.view

import android.content.Intent
import  br.com.zup.rickandmortyemsimcity.ui.home.viewmodel.HomeViewModel
import br.com.zup.rickandmortyemsimcity.domain.model.Character
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.rickandmortyemsimcity.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.rickandmortyemsimcity.databinding.ActivityHomeBinding
import br.com.zup.rickandmortyemsimcity.ui.detail.view.DetailActivity


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }
    private val adapter: CharacterAdapter by lazy {
        CharacterAdapter(mutableListOf(), this::clickCharacter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCharacters()
        intObserver()
        showRV()
    }

    private fun clickCharacter(character: Character) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("CHARACTER", character)
        startActivity(intent)
    }

    private fun showRV() {
        binding.rvListCharacters.adapter = adapter
        binding.rvListCharacters.layoutManager = GridLayoutManager(this, 2)
    }

    private fun intObserver() {
        viewModel.apiResponse.observe(this) {
            adapter.updateList(it as MutableList<Character>)
        }
    }


}




