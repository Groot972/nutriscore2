package com.example.nutriscore

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class PokemonApi(
    val height : Int,
    val name : String,
    val species : PokemonSpecies,
)


interface API{
    @GET("pokemon/ditto")
    fun getPokemon() : Deferred<PokemonApi>
}

object NetworkManager {
    val api = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(API::class.java)

    suspend fun getPokemon() : PokemonApi {
        return api.getPokemon().await()
    }
}



