package com.example.rickandmorty.remote

import com.example.rickandmorty.model.CharacterListModel
import com.example.rickandmorty.model.RMCharacter
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path

interface RMApiService {
    @GET("/api/character")
    suspend fun getAllCharacters(): Response<CharacterListModel>
    @GET("/api/character/{id}")
    suspend fun  getCharacter(@Path("id")id: String): Response<RMCharacter>
}