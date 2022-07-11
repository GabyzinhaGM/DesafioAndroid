package br.com.zup.rickandmortyemsimcity.data.model

data class APIResponse(
    val info: Info,
    val results: List<Result>
)