package com.example.android3_2

import android.app.Application
import androidx.room.Room
import com.example.android3_2.room.AppDatabase


private const val DATABASE_NAME = "implemntation"

class App : Application() {
    companion object {
        lateinit var db: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}