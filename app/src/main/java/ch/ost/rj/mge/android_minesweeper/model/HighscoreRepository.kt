package ch.ost.rj.mge.android_minesweeper.model

import android.content.Context
import androidx.room.Room
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty
import ch.ost.rj.mge.android_minesweeper.model.database.HighscoreDatabase
import java.time.LocalDateTime

class HighscoreRepository(private val database: HighscoreDatabase) {
    companion object {
        fun initialize(context : Context): HighscoreRepository {
            val database = Room.databaseBuilder(context,
                HighscoreDatabase::class.java,"highscore.db").allowMainThreadQueries().build()

            //TODO REMOVE!!!
            if (database.highscoreDao().highscores.isEmpty()){
                database.highscoreDao().add(Highscore("shidairyu", LocalDateTime.now(), Difficulty.Normal, 180))
                database.highscoreDao().add(Highscore("sharuka", LocalDateTime.now(), Difficulty.Hard, 4))
            }

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