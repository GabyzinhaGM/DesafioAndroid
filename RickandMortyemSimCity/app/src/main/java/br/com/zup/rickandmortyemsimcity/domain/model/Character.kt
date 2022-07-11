package br.com.zup.rickandmortyemsimcity.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    var name: String = "",
    var status: String,
    var gender: String,
    var image: String
) : Parcelable