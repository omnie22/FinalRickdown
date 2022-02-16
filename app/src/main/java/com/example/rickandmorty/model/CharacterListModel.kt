package com.example.rickandmorty.model

import android.icu.text.IDNA
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterListModel(
    val info: Info,
    val results: List<RMCharacter>
)

@JsonClass(generateAdapter = true)
data class Info (
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
    )
@JsonClass(generateAdapter = true)
data class RMCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>
)
@JsonClass(generateAdapter = true)
data class Origin (
    val name: String,
    val url: String
        )
@JsonClass(generateAdapter = true)
data class Location (
    val name: String,
    val url: String
        )
//"count": 826,
//"pages": 42,
//"next": "https://rickandmortyapi.com/api/character?page=2",
//"prev": null