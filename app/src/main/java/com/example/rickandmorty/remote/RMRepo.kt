package com.example.rickandmorty.remote

import com.example.rickandmorty.model.CharacterListModel
import com.example.rickandmorty.model.RMCharacter
import retrofit2.Response

object RMRepo {
    suspend fun getChars(): Response<CharacterListModel>{
        return RetrofitInstance.rmApiService.getAllCharacters()
    }
    suspend fun getChar(id: String): Response<RMCharacter>{
        return RetrofitInstance.rmApiService.getCharacter(id)
    }
}