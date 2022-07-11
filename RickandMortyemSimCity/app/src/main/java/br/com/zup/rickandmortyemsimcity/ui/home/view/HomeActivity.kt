package br.com.zup.rickandmortyemsimcity.ui.home.view

import android.content.Intent
import  br.com.zup.rickandmortyemsimcity.ui.home.viewmodel.HomeViewModel
import  br.com.zup.rickandmortyemsimcity.data.model.Result
import br.com.zup.rickandmortyemsimcity.domain.model.Character
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import br.com.zup.rickandmortyemsimcity.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import br.com.zup.rickandmortyemsimcity.databinding.ActivityDetailBinding
import br.com.zup.rickandmortyemsimcity.ui.detail.view.DetailActivity


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.getCharacters()
        intObserver()


    }


    private fun intObserver() {
        viewModel.apiResponse.observe(this) {
            useAdapter(it)
        }
    }

    private fun useAdapter(charactersResponse: List<Character>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rvListCharacters)
        recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val characters = listOf(
            charactersResponse
        )
        recyclerView.adapter = CharacterAdapter(charactersResponse)

    }


}




