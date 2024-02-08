package com.example.android3_2.data.repositories

import com.example.android3_2.R
import com.example.android3_2.data.models.Character

class CharacterRepositories {

    val heroes = mutableListOf(
        Character(R.drawable.img, "Hello every one")
    )

    fun getCharacter() = heroes

    fun addCharacter(character: Character){
      heroes.add(character)
    }
}