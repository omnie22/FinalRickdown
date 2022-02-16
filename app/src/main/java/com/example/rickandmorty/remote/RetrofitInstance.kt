package com.example.rickandmorty.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://rickandmortyapi.com"
    private val RMApiRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val rmApiService: RMApiService = RMApiRetrofit.create(RMApiService::class.java)

//    val smashLoungeService: SmashLoungeService =
//        smashLoungeRetrofit.create(SmashLoungeService::class.java)
}