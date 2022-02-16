package com.example.rickandmorty.remote

import com.example.rickandmorty.model.CharacterListModel
import retrofit2.Response

object RMRepo {
    suspend fun getChars(): Response<CharacterListModel>{
        return RetrofitInstance.rmApiService.getAllCharacters()
    }
}