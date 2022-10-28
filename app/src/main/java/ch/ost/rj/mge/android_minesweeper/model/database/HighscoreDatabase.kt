package ch.ost.rj.mge.android_minesweeper.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ch.ost.rj.mge.android_minesweeper.model.Highscore

@Database(entities = [Highscore::class], version = 1)
@TypeConverters(Converters::class)
abstract class HighscoreDatabase : RoomDatabase() {
    abstract fun highscoreDao(): HighscoreDao
}