package com.example.rickandmorty.remote

import com.example.rickandmorty.model.CharacterListModel
import retrofit2.Response
import retrofit2.http.GET

interface RMApiService {
    @GET("/api/character")
    suspend fun getAllCharacters(): Response<CharacterListModel>
}