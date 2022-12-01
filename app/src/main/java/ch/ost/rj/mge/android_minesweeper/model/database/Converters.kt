package ch.ost.rj.mge.android_minesweeper.model.database

import androidx.room.TypeConverter
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty

class Converters {
    @TypeConverter
    fun difficultyToInt(difficulty: Difficulty): Int {
        return Difficulty.convertToInt(difficulty)
    }

    @TypeConverter
    fun intToDifficulty(value: Int): Difficulty {
        return Difficulty.convertFromInt(value)
    }
}