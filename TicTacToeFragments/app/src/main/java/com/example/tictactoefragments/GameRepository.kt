package com.example.tictactoefragments

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.tictactoefragments.Database.GameDatabase
import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Executors


private const val DATABASE_NAME = "game-database"

class GameRepository private constructor(context: Context) {
    private val database : GameDatabase = databaseBuilder(
        context.applicationContext, GameDatabase::class.java, DATABASE_NAME
    ).build()

    private val gameDao = database.GameDao()
    private val executor = Executors.newSingleThreadExecutor()

    //fun getGames(): LiveData
    //fun getGame(id: UUID): LiveData

    /*fun updateGame(game: Game){
        executor.execute{
            gameDao.updateGame(game)
        }
    }
    fun addGame(game: Game){
        executor.execute{
            gameDao.addGame(game)
        }
    }*/

    companion object{
        private var INSTANCE: GameRepository? = null
        fun initialize (context: Context){
            if (INSTANCE == null){
                INSTANCE = GameRepository(context)
            }
        }
        fun get(): GameRepository{
            return INSTANCE ?:
                    throw IllegalStateException("GameRepository must be initialized")
        }
    }
}