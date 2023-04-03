package com.example.myapplication.data.api.data
import com.example.myapplication.data.api.data.model.Character
import retrofit2.http.GET

interface CharacterApi {

    @GET(ApiConstants.END_POINTS)
    suspend fun getCharacter():List<Character>
}