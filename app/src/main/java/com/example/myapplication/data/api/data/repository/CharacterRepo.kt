package com.example.myapplication.data.api.data.repository

import com.example.myapplication.data.api.data.CharacterApi
import com.example.myapplication.data.api.data.model.Character
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val characterApi: CharacterApi
){
    suspend fun getCharacters(): List<Character> {
        return characterApi.getCharacter()
    }
}