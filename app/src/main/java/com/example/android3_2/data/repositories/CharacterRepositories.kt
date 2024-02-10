package com.example.android3_2.data.repositories

import com.example.android3_2.App
import com.example.android3_2.R
import com.example.android3_2.data.models.Character

class CharacterRepositories {

    fun getCharacters() = App.db.noteDao().getAllNotes()

    fun addCharacter(character: Character){
      App.db.noteDao().addNote(character)
    }
}