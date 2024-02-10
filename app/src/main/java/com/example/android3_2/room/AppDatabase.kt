package com.example.android3_2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android3_2.data.models.Character
import com.example.android3_2.room.dao.NoteDao

@Database(entities = [Character::class], version = 2, exportSchema = false)

abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}