package ch.ost.rj.mge.android_minesweeper.model

import android.content.Context
import androidx.room.Room
import ch.ost.rj.mge.android_minesweeper.model.database.HighscoreDatabase

class HighscoreRepository(private val database: HighscoreDatabase) {
    companion object {
        fun initialize(context : Context): HighscoreRepository {
            val database = Room.databaseBuilder(context,
                HighscoreDatabase::class.java,"highscore.db").allowMainThreadQueries().build()
            return HighscoreRepository(database)
        }
    }

    fun getHighscores(): List<Highscore> {
        return database.highscoreDao().highscores
    }

    fun addHighscore(highscore: Highscore) {
        database.highscoreDao().add(highscore)
    }

    fun removeAll(){
        database.highscoreDao().removeAll()
    }
}