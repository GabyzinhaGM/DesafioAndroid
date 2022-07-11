package br.com.zup.rickandmortyemsimcity.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.rickandmortyemsimcity.data.RetrofitService
import kotlinx.coroutines.launch
import  br.com.zup.rickandmortyemsimcity.domain.repository.CharacterRepository
import  br.com.zup.rickandmortyemsimcity.domain.model.Character

class HomeViewModel : ViewModel() {
    private val _repository: CharacterRepository = CharacterRepository()
    private val _apiResponse = MutableLiveData<List<Character>>()
    val apiResponse: LiveData<List<Character>> = _apiResponse

    fun getCharacters() {
        viewModelScope.launch {
            _apiResponse.value = _repository.getCharacters()
        }
    }

}

