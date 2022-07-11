package br.com.zup.rickandmortyemsimcity.data

import br.com.zup.rickandmortyemsimcity.data.model.APIResponse
import br.com.zup.rickandmortyemsimcity.data.model.Result
import br.com.zup.rickandmortyemsimcity.data.model.Info
import br.com.zup.rickandmortyemsimcity.data.model.Location
import br.com.zup.rickandmortyemsimcity.data.model.Origin
import retrofit2.http.GET


interface RickAPI {

    @GET("character")
    suspend fun getCharacterss(): APIResponse

}