package com.example.android3_2.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android3_2.data.models.Character


@Dao
interface NoteDao {
    @Query("SELECT * FROM  implemntation")
    fun getAllNotes(): List<Character>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(character: Character)

    @Query("DELETE FROM implemntation")
    fun clear()


}