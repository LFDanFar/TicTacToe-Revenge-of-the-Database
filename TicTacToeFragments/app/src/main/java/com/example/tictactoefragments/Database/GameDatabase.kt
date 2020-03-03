package com.example.tictactoefragments.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tictactoefragments.Game

@Database(entities = [Game::class], version = 1)
@TypeConverters(GameTypeConverters::class)
abstract class GameDatabase: RoomDatabase(){
    abstract fun GameDao(): GameDao
}