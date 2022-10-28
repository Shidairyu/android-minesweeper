package ch.ost.rj.mge.android_minesweeper.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ch.ost.rj.mge.android_minesweeper.model.Highscore

@Dao
interface HighscoreDao {
    @get:Query("SELECT * FROM highscores")
    val highscores: List<Highscore>

    @Insert
    fun add(highscore: Highscore)
}