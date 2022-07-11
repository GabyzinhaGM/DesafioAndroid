package br.com.zup.rickandmortyemsimcity.domain.repository


import android.util.Log
import  br.com.zup.rickandmortyemsimcity.domain.model.Character
import br.com.zup.rickandmortyemsimcity.data.model.APIResponse
import br.com.zup.rickandmortyemsimcity.data.model.Result
import br.com.zup.rickandmortyemsimcity.data.model.Info
import br.com.zup.rickandmortyemsimcity.data.model.Location
import br.com.zup.rickandmortyemsimcity.data.model.Origin
import br.com.zup.rickandmortyemsimcity.data.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CharacterRepository {

    suspend fun getCharacters(): List<Character> {
        try {
            val response = withContext(Dispatchers.IO) {
                RetrofitService.apiService.getCharacterss()
            }
            return toListCharacter(response.results)
        } catch (ex: Exception) {
            Log.i("Error", "Error ----- > ${ex.message}")
        }
        return listOf<Character>(
            Character(
                name = "",
                species = "",
                status = "",
                gender = "",
                image = ""
            )
        )
    }

    private fun toListCharacter(results: List<Result>): List<Character> {
        var characters: MutableList<Character> = mutableListOf<Character>()

        for (i in results) {
            characters.add(
                Character(
                    name = i.name,
                    species = i.species,
                    status = i.status,
                    gender = i.gender,
                    image = i.image
                )
            )
        }
        return characters
    }


}